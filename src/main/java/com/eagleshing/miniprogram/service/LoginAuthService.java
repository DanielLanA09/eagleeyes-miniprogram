package com.eagleshing.miniprogram.service;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import com.eagleshing.miniprogram.domain.Cover;
import com.eagleshing.miniprogram.domain.MiniUser;
import com.eagleshing.miniprogram.domain.MyUnlockedProject;

import org.springframework.stereotype.Service;

/**
 * LoginAuthService
 */
@Service
public class LoginAuthService {

    @PersistenceContext
    private EntityManager em;

    /**
     * Add unlock point for an user
     * 
     * @param userId user id
     * @return updated user
     */
    public MiniUser addLockOnePoint(int userId) {
        MiniUser user = em.find(MiniUser.class, userId);
        user.setSharedTimes(user.getRemainUnlockPoint() + 1);
        user.setRemainUnlockPoint(user.getRemainUnlockPoint() + 1);
        em.persist(user);
        return user;
    }

    /**
     * record this unlocked project information and reduce one free unlock point of
     * the user
     * 
     * @param projectId project id
     * @param userId    user id
     * @return whether the user haved unlocked the project.
     */
    @Transactional
    public Boolean unlockProject(int projectId, int userId) {
        MiniUser user = em.find(MiniUser.class, userId);
        Cover cover = em.find(Cover.class, projectId);
        List<MyUnlockedProject> _Project = em
                .createNamedQuery("MyUnlockedProject.findUnlockedRecord", MyUnlockedProject.class)
                .setParameter("projectId", projectId).setParameter("userId", userId).getResultList();
        if (_Project.size() > 0) {
            return true;
        } else {
            if (user.getRemainUnlockPoint() > 0) {
                MyUnlockedProject myUnlockedProject = new MyUnlockedProject(user.getId(), user.getNickName(),
                        cover.getId(), cover.getTitle(), new Date(), user.getSharedTimes());

                user.setRemainUnlockPoint(user.getRemainUnlockPoint() - 1);
                em.persist(myUnlockedProject);
                em.persist(user);
                return true;
            } else {
                return false;
            }
        }
    }
}