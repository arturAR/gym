package com.java.academy.gym.repository;

import com.java.academy.gym.model.Club;
import com.java.academy.gym.model.ClubLocal;
import com.java.academy.gym.model.ContactInfo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Club repo
 */
@Repository
public class ClubRepo extends BaseRepository {

    @SuppressWarnings("unchecked")
    public Optional<Club> findClubByNameAndLangCode(Long id, String langCode) {
        // TODO add contact info join
        List<Object[]> result = getEntityManager()
                .createNativeQuery(
                        "SELECT c.ID n, cl.NAME, cl.DESCRIPTION, ci.CITY, ci.ADDRESS, ci.PHONE_NUMBER, ci.EMAIL FROM CLUBS c " +
                                " LEFT JOIN CONTACT_INFOS ci ON c.CONTACT_INFOS_ID=ci.ID" +
                                " INNER JOIN CLUB_LOCALS cl ON c.ID=cl.REF_CLUB_ID AND cl.LANG_CODE=:langCode " +
                                " WHERE c.ID=:id")
                .setParameter("id", id)
                .setParameter("langCode", langCode)
                .getResultList();

        if (result != null && !result.isEmpty()) {
            ClubLocal clubLocal = new ClubLocal();
            clubLocal.setName((String) result.get(0)[1]);
            clubLocal.setDescription((String) result.get(0)[2]);

            ContactInfo contactInfo = new ContactInfo();
            contactInfo.setCity((String) result.get(0)[3]);
            contactInfo.setAddress((String) result.get(0)[4]);
            contactInfo.setPhone((String) result.get(0)[5]);
            contactInfo.setEmail((String) result.get(0)[6]);

            Club club = new Club();
            club.setId(id);
            club.setClubLocal(clubLocal);
            club.setContactInfo(contactInfo);
            return Optional.of(club);
        } else {
            return Optional.empty();
        }
    }

    //TODO change to needed fields
    @SuppressWarnings("unchecked")
    public List<Club> findAll(String langCode) {
        List<Club> clubs = getEntityManager()
                .createNativeQuery(
                        "SELECT * FROM CLUBS c " +
                                "INNER JOIN CLUB_LOCALS cl ON c.ID=cl.REF_CLUB_ID AND cl.LANG_CODE=:langCode",
                        Club.class)
                .setParameter("langCode", langCode)
                .getResultList();
        clubs.stream().forEach(c -> {
            c.setClubLocal(
                    c.getMapLocals()
                            .entrySet()
                            .stream()
                            .filter(l -> l.getKey().getLanguageCode().equals(langCode))
                            .findFirst()
                            .get()
                            .getValue());
        });
        return clubs;
    }
}
