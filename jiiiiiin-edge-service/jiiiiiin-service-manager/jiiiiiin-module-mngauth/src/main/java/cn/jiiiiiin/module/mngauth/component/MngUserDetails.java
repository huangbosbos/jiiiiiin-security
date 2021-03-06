package cn.jiiiiiin.module.mngauth.component;

import cn.jiiiiiin.module.common.dto.mngauth.AdminDto;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.social.security.SocialUserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author jiiiiiin
 */
@Getter
@Setter
@EqualsAndHashCode(of = "admin")
@NoArgsConstructor
public class MngUserDetails implements SocialUserDetails {

    private static final long serialVersionUID = -8362660409491439833L;

    private AdminDto admin;

    public MngUserDetails(AdminDto admin) {
        this.admin = admin;
    }

    /**
     * 简化：AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER");
     *
     * @return
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getGrantedAuthority(admin);
    }

    public static List<SimpleGrantedAuthority> getGrantedAuthority(AdminDto admin) {
        return admin.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority("ROLE_" + role.getAuthorityName()))
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return admin.getPassword();
    }

    @Override
    public String getUsername() {
        return admin.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public String getUserId() {
        return admin.getUsername();
    }
}
