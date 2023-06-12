<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>API-04_UpdateProfile</name>
   <tag></tag>
   <elementGuidId>5e7fdef7-c6e6-4c50-84ae-0a03080034eb</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <autoUpdateContent>false</autoUpdateContent>
   <connectionTimeout>-1</connectionTimeout>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;{\n  \&quot;Id\&quot;: ${id},\n  \&quot;Name\&quot;: \&quot;${name}\&quot;,\n  \&quot;Photos\&quot;: [\n    {\n      \&quot;Comments\&quot;: [\n        {\n          \&quot;Content\&quot;: \&quot;string\&quot;,\n          \&quot;Id\&quot;: 0,\n          \&quot;Profile\&quot;: {}\n        }\n      ],\n      \&quot;Content\&quot;: \&quot;string\&quot;,\n      \&quot;ContentType\&quot;: \&quot;string\&quot;,\n      \&quot;Id\&quot;: 0,\n      \&quot;Name\&quot;: \&quot;string\&quot;\n    }\n  ]\n}&quot;,
  &quot;contentType&quot;: &quot;application/json&quot;,
  &quot;charset&quot;: &quot;UTF-8&quot;
}</httpBodyContent>
   <httpBodyType>text</httpBodyType>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Content-Type</name>
      <type>Main</type>
      <value>application/json</value>
      <webElementGuid>f6e0740d-984e-4d0e-91e6-2212f16b1692</webElementGuid>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Authorization</name>
      <type>Main</type>
      <value>Bearer ${tokenkey}</value>
      <webElementGuid>9428a4b5-a5f2-4e82-ab24-5f9c8b710699</webElementGuid>
   </httpHeaderProperties>
   <katalonVersion>8.6.0</katalonVersion>
   <maxResponseSize>-1</maxResponseSize>
   <migratedVersion>5.4.1</migratedVersion>
   <restRequestMethod>PUT</restRequestMethod>
   <restUrl>${url}</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceEndpoint></soapServiceEndpoint>
   <soapServiceFunction></soapServiceFunction>
   <socketTimeout>-1</socketTimeout>
   <useServiceInfoFromWsdl>true</useServiceInfoFromWsdl>
   <variables>
      <defaultValue>GlobalVariable.A4_TOKENKEY</defaultValue>
      <description></description>
      <id>6288083c-47e4-4fcf-af4f-e7986d2e944b</id>
      <masked>false</masked>
      <name>tokenkey</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.A4_URL_PROFILEV2</defaultValue>
      <description></description>
      <id>e1dd1e14-1bcf-4d63-974a-b05d75a157ae</id>
      <masked>false</masked>
      <name>url</name>
   </variables>
   <variables>
      <defaultValue>''</defaultValue>
      <description></description>
      <id>5e77fad8-3e10-4ecc-a767-fe7e190bec97</id>
      <masked>false</masked>
      <name>name</name>
   </variables>
   <variables>
      <defaultValue>0</defaultValue>
      <description></description>
      <id>819c6ded-32a8-4ecd-8cf3-f54ca06f6bfb</id>
      <masked>false</masked>
      <name>id</name>
   </variables>
   <verificationScript>import static org.assertj.core.api.Assertions.*

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webservice.verification.WSResponseManager

import groovy.json.JsonSlurper
import internal.GlobalVariable as GlobalVariable

RequestObject request = WSResponseManager.getInstance().getCurrentRequest()

ResponseObject response = WSResponseManager.getInstance().getCurrentResponse()</verificationScript>
   <wsdlAddress></wsdlAddress>
</WebServiceRequestEntity>
