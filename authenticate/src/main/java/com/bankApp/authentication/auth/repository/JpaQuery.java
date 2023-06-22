package com.bankApp.authentication.auth.repository;

        import com.bankApp.authentication.auth.dto.request.UpdateUserRequest;
        import com.bankApp.authentication.auth.model.User;
        import org.springframework.stereotype.Repository;

        import javax.persistence.EntityManager;
        import javax.persistence.PersistenceContext;
        import javax.transaction.Transactional;

        @Repository
@Transactional
public class JpaQuery {

    @PersistenceContext
    private EntityManager entityManager;

    public User updateUserDetails(UpdateUserRequest request) {
        String jpql = "UPDATE User e SET e.email = :email, e.phone = :phone, e.address = :address, e.updateDate = :updateDate where e.userId =: userId";

        entityManager.createQuery(jpql)
                .setParameter("email", request.getEmail())
                .setParameter("phone", request.getPhone())
                .setParameter("address", request.getAddress())
                .setParameter("updateDate", request.getUpdateDate())
                .setParameter("userId", request.getUserId())
                .executeUpdate();


        return entityManager.find(User.class, request.getUserId());
    }
}
