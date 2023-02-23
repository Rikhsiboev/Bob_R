package Bob_R.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan("Bob_R")
@ComponentScan(basePackages = {"Bob_R.config","Bob_R.proxy","Bob_R.repository","Bob_R.service"})
public class CommentConfig {
}
