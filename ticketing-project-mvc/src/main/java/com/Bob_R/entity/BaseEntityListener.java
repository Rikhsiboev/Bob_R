package com.Bob_R.entity;

import com.Bob_R.entity.common.UserPrincipal;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import javax.persistence.EntityListeners;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.net.Authenticator;
import java.time.LocalDateTime;

@Component
public class BaseEntityListener extends AuditingEntityListener {




    @PrePersist // when ever i change in db it weill been created automatic
    private void onPrePersist(BaseEntity baseEntity) {//@EntityListeners((BaseEntity.class))
            // which user from spring security
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        // update time
        baseEntity.setInsertDateTime(LocalDateTime.now());
        baseEntity.setLastUpdateDateTime(LocalDateTime.now());

        //checking null or anonymousUser
        if (authentication != null && !authentication.getName().equals("anonymousUser")) {

            Object principal = authentication.getPrincipal();

            baseEntity.setInsertUserId(((UserPrincipal) principal).getId());
            baseEntity.setLastUpdateUserId(((UserPrincipal) principal).getId());
        }
    }

    @PreUpdate// when ever i change in db it weill been created automatic
    private void onPreUpdate(BaseEntity baseEntity) {//@EntityListeners((BaseEntity.class))
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        baseEntity.setLastUpdateDateTime(LocalDateTime.now());

        //checking null or anonymousUser
        if (authentication != null && !authentication.getName().equals("anonymousUser")) {

            Object principal = authentication.getPrincipal();//get that user from Spring
                        // set user       //mapper     // spring   // UserDetails class from spring
            baseEntity.setInsertUserId(((UserPrincipal) principal).getId()); // set that id
            baseEntity.setLastUpdateUserId(((UserPrincipal) principal).getId());
        }

    }
}
