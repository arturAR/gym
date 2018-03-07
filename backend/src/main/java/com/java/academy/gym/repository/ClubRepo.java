package com.java.academy.gym.repository;

import com.java.academy.gym.model.Club;
import com.java.academy.gym.model.ClubLocal;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
                        "SELECT c.ID n, cl.NAME, cl.DESCRIPTION desc FROM CLUBS c " +
                                " INNER JOIN CLUB_LOCALS cl ON c.ID=cl.REF_CLUB_ID AND cl.LANG_CODE=:langCode " +
                                " WHERE c.ID=:id")
                .setParameter("id", id)
                .setParameter("langCode", langCode)
                .getResultList();

        if (result != null && !result.isEmpty()) {
            ClubLocal clubLocal = new ClubLocal();
            clubLocal.setName((String) result.get(0)[1]);
            clubLocal.setDescription((String) result.get(0)[2]);
            Club club = new Club();
            club.setId(id);
            club.setClubLocal(clubLocal);
            return Optional.of(club);
        } else {
            return Optional.empty();
        }
    }

    @SuppressWarnings("unchecked")
    public List<Club> findAll(String langCode) {
        return getEntityManager().createNativeQuery(
                "SELECT * FROM CLUBS c INNER JOIN CLUB_LOCALS cl ON c.ID=cl.REF_CLUB_ID AND cl.LANG_CODE=:langCode",
                    Club.class)
                .setParameter("langCode", langCode)
                .getResultList();
    }
}
