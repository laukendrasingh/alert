### OVERVIEW:
It's a containerized microservice app developed with spring-boot and java-11, using H2 in-memory DB.

### 1. BUILD & RUN DOCKER IMAGE AT LOCAL:
    1. Install docker
    2. Start docker using docker desktop
    3. Got to IntelliJ project and set docker path:  export PATH="/Applications/Docker.app/Contents/Resources/bin:$PATH"
    4. Build project: mvn clean install
    5. Build docker image:  sudo docker build -t alert .
    6. Run docker image: docker run -p 8080:8080 alert
    7. Run from browser: http://localhost:8080/alerts

### 2. CREATE RESOURCES AT AZURE PORTAL:
    1. Resource group: RG-LnD-QA
    2. ACR: To store docker images: ACRLnDQA
    3. AKS: To run images in cluster: AKS-LnD-QA

### 3. CREATE BUILD PIPELINE ON AZURE DEV PORTAL:
    1. Git source: To checkout source code
    2. Agent job: Ubuntu Latest. It's a VM on which thse steps executes 
    3. Maven pom.xml: To build java code
    4. Build an image: with azure agent-Ubuntu Latest
    5. Push an image: Into ACR
    6. Push artifact
    7. Triggers: Enable continuous integration on branch 'main'

### 4. CREATE RELEASE PIPELINE ON AZURE:
    1. Select artifact
    2. Agent job: Ubuntu Latest
    3. kubectl login: Login into AKS
    4. kubectl apply: Fecth image from ACR and run on AKS
