package com.ifast.common.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import com.ifast.api.config.JWTConfig;

/**
 * <pre>
 * </pre>
 * 
 * <small> 2018年4月6日 | Aron</small>
 */
@Component
@PropertySource("classpath:application.properties")
public class IFastConfig {
    /**
     * 项目名，末尾不带 "/"
     */
	@Autowired(required = false)
	@Value("${ifast.projectName}")
    private String projectName;
    /**
     * 项目根目录，末尾带 "/"
     */
	@Autowired(required = false)
	@Value("${ifast.projectRootURL}")
    private String projectRootURL;

    /**
     * 演示模式
     */
	@Autowired(required = false)
	@Value("${ifast.demoMode}")
    private boolean demoMode;
    /**
     * 调试模式
     */
	@Autowired(required = false)
	@Value("${ifast.devMode}")
    private boolean devMode;
	
	@Autowired(required = false)
    private JWTConfig jwt;

    public boolean isDemoMode() {
        return demoMode;
    }

    public void setDemoMode(boolean demoMode) {
        this.demoMode = demoMode;
    }

    public boolean isDevMode() {
        return devMode;
    }

    public void setDevMode(boolean devMode) {
        this.devMode = devMode;
    }

    public String getProjectRootURL() {
        return projectRootURL;
    }

    public void setProjectRootURL(String projectRootURL) {
        this.projectRootURL = projectRootURL;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }


    public JWTConfig getJwt() {
        return jwt;
    }

    public void setJwt(JWTConfig jwt) {
        this.jwt = jwt;
    }

    @Override
    public String toString() {
        return "IFastConfig [projectName=" + projectName + ", projectRootURL=" + projectRootURL + ", demoMode="
                + demoMode + ", devMode=" + devMode + ", jwt=" + jwt + "]";
    }

}
