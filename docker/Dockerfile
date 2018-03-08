FROM jenkins/jenkins:lts

ENV CASC_JENKINS_CONFIG=/usr/share/jenkins/ref/jenkins.yaml

COPY --chown=jenkins id_rsa /usr/share/jenkins/ref/id_rsa
COPY --chown=jenkins id_rsa.pub /usr/share/jenkins/ref/id_rsa.pub

RUN echo $JENKINS_VERSION > /usr/share/jenkins/ref/jenkins.install.UpgradeWizard.state
RUN echo $JENKINS_VERSION > /usr/share/jenkins/ref/jenkins.install.InstallUtil.lastExecVersion

COPY --chown=jenkins configuration-as-code.hpi /usr/share/jenkins/ref/plugins/configuration-as-code.jpi

COPY --chown=jenkins plugins.txt /usr/share/jenkins/ref/plugins.txt
RUN /usr/local/bin/install-plugins.sh < /usr/share/jenkins/ref/plugins.txt

COPY --chown=jenkins jenkins.yaml /usr/share/jenkins/ref/jenkins.yaml

# Copy some old-fashioned xml configuration files because I do not yet know if,
# or how to configure these things with the configuration-as-code plugin
COPY --chown=jenkins xmls/hudson.plugins.gradle.Gradle.xml /usr/share/jenkins/ref/hudson.plugins.gradle.Gradle.xml
COPY --chown=jenkins xmls/hudson.tasks.Maven.xml /usr/share/jenkins/ref/hudson.tasks.Maven.xml
COPY --chown=jenkins xmls/javaposse.jobdsl.plugin.GlobalJobDslSecurityConfiguration.xml /usr/share/jenkins/ref/javaposse.jobdsl.plugin.GlobalJobDslSecurityConfiguration.xml
COPY --chown=jenkins xmls/jenkins.CLI.xml /usr/share/jenkins/ref/jenkins.CLI.xml
COPY --chown=jenkins xmls/org.jenkinsci.plugins.docker.commons.tools.DockerTool.xml /usr/share/jenkins/ref/org.jenkinsci.plugins.docker.commons.tools.DockerTool.xml