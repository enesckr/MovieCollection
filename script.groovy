def buildApp() {
    sh "mvn clean install -DskipTests"
    sh "mvn spring-boot:run"
    echo 'building the application ...'
    echo 'builded the application ...'
} 

def testApp() {
    echo 'testing the application ...'
} 

def deployApp() {
    echo 'deploying the application ...'
    echo "deploying version ${params.VERSION}"
} 

return this
