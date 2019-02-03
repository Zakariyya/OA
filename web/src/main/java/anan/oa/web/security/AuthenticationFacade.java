package anan.oa.web.security;

import org.springframework.security.core.Authentication;

/**
 * @author anan
 * Created on 2019.01.28
 */
public interface AuthenticationFacade {
  Authentication getAuthentication();
}
