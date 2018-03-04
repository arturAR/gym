package com.java.academy.gym.repository;

import com.java.academy.gym.model.Club;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Club repo
 */
@Repository
public class ClubRepo extends BaseRepository {

    @SuppressWarnings("unchecked")
    public Optional<Club> findClubByNameAndLangCode(String clubName, String langCode) {
        List<Object[]> result = getEntityManager()
                .createNativeQuery(
                        "SELECT c.NAME n, cl.DESCRIPTION desc FROM CLUBS c " +
                                " INNER JOIN CLUB_LOCALS cl ON c.ID=cl.REF_CLUB_ID AND cl.LANG_CODE=:langCode " +
                                " WHERE c.NAME=:clubName")
                .setParameter("clubName", clubName)
                .setParameter("langCode", langCode)
                .getResultList();

        if (result != null && !result.isEmpty()) {
            Club club = new Club();
            club.setName((String) result.get(0)[0]);
            club.setDescription((String) result.get(0)[1]);
            return Optional.of(club);
        } else {
            return Optional.empty();
        }
    }
}
