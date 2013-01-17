[condition][]Somebody looked at data in "{service}"=$req : RequestDescription(serviceName == "{service}", operationType == "fetch");
[condition][]Somebody called method "{method}" on service "{service}"=$req : RequestDescription(serviceName == "{service}", methodName == "{method}");

[condition][]Exist request on=$req : RequestDescription()
[condition][]- service "{service}"=serviceName=="{service}"
[condition][]- operation "{operType}"=operationType=="{operType}"
[condition][]- method "{method}"=methodName=="{method}"
[condition][]Exist request=$req : RequestDescription()

[consequence][]Log {message}=System.out.println(">>> "+{message});
[consequence][]Audit request {description}=makeAuditRecord(serviceContext, servlet, $req.getServiceName(),  $req.getOperationType(), $req.getMethodName(), {description});
[consequence][]Audit {audit}=makeAuditRecord(serviceContext, servlet, {audit});

[keyword][]RULE=rule
[keyword][]WHEN=when
[keyword][]THEN=then
[keyword][]END=end
[keyword][]unique-group=activation-group
[keyword][]priority=salience
