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
