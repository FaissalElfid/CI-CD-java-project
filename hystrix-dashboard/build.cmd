for /F "tokens=*" %%i IN ('minikube docker-env') do call %%i
START /WAIT C:\Users\faiss\.jdks\temurin-11.0.13\bin\java.exe -Dmaven.multiModuleProjectDirectory=D:\faissal\Documents\5-S5\Microservices\kubernetes\Springboot-Microservice-kubernetes\hystrix-dashboard "-Dmaven.home=D:\JetBrains\IntelliJ IDEA 2021.2.3\plugins\maven\lib\maven3" "-Dclassworlds.conf=D:\JetBrains\IntelliJ IDEA 2021.2.3\plugins\maven\lib\maven3\bin\m2.conf" "-Dmaven.ext.class.path=D:\JetBrains\IntelliJ IDEA 2021.2.3\plugins\maven\lib\maven-event-listener.jar" "-javaagent:D:\JetBrains\IntelliJ IDEA 2021.2.3\lib\idea_rt.jar=57938:D:\JetBrains\IntelliJ IDEA 2021.2.3\bin" -Dfile.encoding=UTF-8 -classpath "D:\JetBrains\IntelliJ IDEA 2021.2.3\plugins\maven\lib\maven3\boot\plexus-classworlds-2.6.0.jar;D:\JetBrains\IntelliJ IDEA 2021.2.3\plugins\maven\lib\maven3\boot\plexus-classworlds.license" org.codehaus.classworlds.Launcher -Didea.version=2021.2.3 package
kubectl delete -n default deployment hystrix-dashboard-app

kubectl delete -n default service hystrix-dashboard-svc

kubectl apply -f ../k8s/hystrix-dashboard.yml
minikube service hystrix-dashboard-svc
