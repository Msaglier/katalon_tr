<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>GetCauses</name>
   <tag></tag>
   <elementGuidId>081ea609-8a46-481d-a2a3-f424cc8dd0d1</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <autoUpdateContent>false</autoUpdateContent>
   <connectionTimeout>0</connectionTimeout>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;{\n  \&quot;wordings\&quot;: [\n    {\n      \&quot;key\&quot;: \&quot;external_long\&quot;,\n      \&quot;value\&quot;: \&quot;katalon_cause_without_category_post\&quot;\n    }\n  ]\n}&quot;,
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
      <webElementGuid>e881ce8f-9dd7-4b80-a4d2-d14d8d343fbf</webElementGuid>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>X-Customer-Id</name>
      <type>Main</type>
      <value>${x_customer}</value>
      <webElementGuid>29cdfcec-e91a-407f-b787-c4eafb8a34e8</webElementGuid>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>X-Coverage</name>
      <type>Main</type>
      <value>${x_coverage}</value>
      <webElementGuid>b6e335c8-b587-4ce1-815d-8cd82ec381a6</webElementGuid>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>X-Contributors</name>
      <type>Main</type>
      <value>${x_contributor}</value>
      <webElementGuid>5bffa53e-1f7d-444b-92ab-76f86fa28e83</webElementGuid>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Authorization</name>
      <type>Main</type>
      <value>${authorization}</value>
      <webElementGuid>9a959480-c547-4f1c-a77d-bd488f8cf012</webElementGuid>
   </httpHeaderProperties>
   <katalonVersion>9.0.0</katalonVersion>
   <maxResponseSize>0</maxResponseSize>
   <migratedVersion>5.4.1</migratedVersion>
   <restRequestMethod>GET</restRequestMethod>
   <restUrl>${GlobalVariable.base_url}/causes/</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceEndpoint></soapServiceEndpoint>
   <soapServiceFunction></soapServiceFunction>
   <socketTimeout>0</socketTimeout>
   <useServiceInfoFromWsdl>true</useServiceInfoFromWsdl>
   <variables>
      <defaultValue>GlobalVariable.x_customer_id</defaultValue>
      <description></description>
      <id>774ea14f-581f-4d59-85f7-c1dbe7d92715</id>
      <masked>false</masked>
      <name>x_customer</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.x_coverage</defaultValue>
      <description></description>
      <id>8141c7b6-6d79-41b1-9d21-45a6b67ccf57</id>
      <masked>false</masked>
      <name>x_coverage</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.x_contributors</defaultValue>
      <description></description>
      <id>b6abc519-9f09-498d-8d0f-836728fb9dc7</id>
      <masked>false</masked>
      <name>x_contributor</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.authorization</defaultValue>
      <description></description>
      <id>482613bd-970f-4eda-97c7-3d86542f805c</id>
      <masked>false</masked>
      <name>authorization</name>
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
