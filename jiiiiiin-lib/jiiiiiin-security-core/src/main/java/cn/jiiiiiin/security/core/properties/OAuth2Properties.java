/**
 *
 */
package cn.jiiiiiin.security.core.properties;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

/**
 * 替代：
 * #security:
 * #  oauth2:
 * #    client:
 * #      client-id: immoc
 * #      client-secret: immocsecret
 *
 * 配置
 *
 * 参考：https://www.jianshu.com/p/576dbf44b2ae
 *
 * `ClientDetailsServiceBuilder.ClientBuilder` 关于应用运行的第三方授权应用信息的配置
 *
 * @author zhailiang
 * @author jiiiiiin
 */
@Setter
@Getter
@NoArgsConstructor
@ToString
public class OAuth2Properties {

    /**
     * 使用jwt时为token签名的秘钥
     * <p>
     * secret是保存在服务器端的，jwt的签发生成也是在服务器端的，secret就是用来进行jwt的签发和jwt的验证，所以，它就是你服务端的私钥，在任何场景都不应该流露出去。一旦客户端得知这个secret, 那就意味着客户端是可以自我签发jwt了。
     * <p>
     * 服务器用其进行签名、客户端用其进行延签，注意要将其进行安全存储，否则任何人都可以模拟应用下发token
     */
    private String jwtSigningKey = "jiiiiiin";

    /**
     * 是否启用默认的`org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter`
     */
    private boolean enableAuthorizationServer = true;

    private boolean useSimpleUserAuthenticationConverter = true;

    /**
     * 客户端配置
     */
    private List<OAuth2ClientProperties> clients = new ArrayList<>();

}
