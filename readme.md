# usage

Run `docker-compose up`  
Go to `localhost:8888`  
Login with `admin` / `admin`  
Go to `Manage Jenkins` -> `Configure Global Security`  
Disable `Enable script security for Job DSL scripts` (not yet possible to configure with the configuration-as-code plugin)  
Go to `Manage Jenkins` -> `Global Tool Configuration`  (not sure yet how to configure this with the configuration-as-code plugin)  
Under `Gradle` click on `Add Gradle` and fill in `4.6` as name, leave `Install automatically` checked and select `version 4.6`  
Under `Maven` click on `Add Maven` and fill in `3.5.3` as name, leave `Install automatically` checked and select `version 3.5.3`  
Click on `Save`

Go to the Jenkins home  
Run the `jenkins/seed` job  
A `projects` folder will be generated with two multibranch pipeline jobs inside  

The public/private key pair in this repository is not used anywhere.  
