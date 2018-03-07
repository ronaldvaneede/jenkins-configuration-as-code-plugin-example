# usage

Run `docker-compose up`  
Go to localhost:8888  
Login with admin / admin  
Go to `Manage Jenkins` -> `Configure Global Security`  
Disable `Enable script security for Job DSL scripts` (not yet possible to configure with the configuration-as-code plugin)  
Run the `jenkins/seed` job  
A `projects` folder will be generated with two multibranch pipeline jobs inside  

The public/private key pair in this repository is not used anywhere.  
