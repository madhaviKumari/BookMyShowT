# BookMyShow Trimmed Application

# System Design Discussion 
To see the design & API documentation [Look at this doc](apidoc.md)<br/>

# Deployment Instructions
To support 10k concurrent requests we can use AWS ELB with Application Load Balancer with minimum configuration of 1 instance c5.xlarge and we can setup the load balancer parameters to suite 10k request in cost effective. 
## Deploy on AWS ElasticBeanstalk through EB Cli
* Install EB CLI <br/>
To install EB CLI [Here is a complete guide](https://docs.aws.amazon.com/elasticbeanstalk/latest/dg/eb-cli3-install.html)

* Clone this repository & unzip, open terminal at root directory of repository.

* Create your elastic beanstalk app 

```bash
bookmyshow $ eb init
```

at this level you need to select region, application name, platform (Choose Java as your application platform), platform version (Choose Java 8), SSH creation. 

Once this is doone you will find  `.elasticbeanstalk`  hidden directory at root level of project, open this directory there will be one yml file `onfig.yml` open this file in your favourite editor & add following lines.

```yml
deploy:
    artifact: target/bookmyshow-0.0.1-SNAPSHOT.jar
```
complete file should look like this.

```yml
branch-defaults:
  default:
    environment: null
    group_suffix: null
deploy:
    artifact: target/bookmyshow-0.0.1-SNAPSHOT.jar
global:
  application_name: dotest
  branch: null
  default_ec2_keyname: aws-eb
  default_platform: Java 8
  default_region: us-west-2
  include_git_submodules: true
  instance_profile: null
  platform_name: null
  platform_version: null
  profile: eb-cli
  repository: null
  sc: null
  workspace_type: Application
```

* Create the resources and launch the application

```bash
bookmyshow $ eb create
```

You need to provide name of environment, DNS CNAME, load balancer type, Spot Fleet requests etc. <br/>
Note: You also need to configure AWS user credential if you are creating first time using eb cli. You need to create a user from AWS [IAM](https://aws.amazon.com/iam/) with [AWSElasticBeanstalkFullAccess](https://docs.aws.amazon.com/elasticbeanstalk/latest/dg/AWSHowTo.iam.managed-policies.html) permission. 
check the application status 

```bash
bookmyshow $ eb status
```

If you are changing the code then package application with maven ``` mvn package ```and deploy it again with ``` eb deploye``` 
