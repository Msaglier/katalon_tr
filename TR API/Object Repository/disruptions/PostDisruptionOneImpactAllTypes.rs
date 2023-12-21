<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>PostDisruptionOneImpactAllTypes</name>
   <tag></tag>
   <elementGuidId>e0391bb8-b0b3-47a4-ba9a-ef2cce3d56db</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <autoUpdateContent>false</autoUpdateContent>
   <connectionTimeout>0</connectionTimeout>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;{\n  \&quot;author\&quot;: \&quot;msa\&quot;,\n  \&quot;contributor\&quot;: \&quot;shortterm.tr_qastif\&quot;,\n  \&quot;reference\&quot;: \&quot;katalon_disruption_post\&quot;,\n  \&quot;cause\&quot;: {\n    \&quot;id\&quot;: \&quot;3a412398-5693-11e7-9ac2-005056a41224\&quot;\n  },\n  \&quot;tags\&quot;: [],\n  \&quot;impacts\&quot;: [\n    {\n      \&quot;messages\&quot;: [\n        {\n          \&quot;text\&quot;: \&quot;katalon POST\&quot;,\n          \&quot;send_notification\&quot;: false,\n          \&quot;notification_date\&quot;: \&quot;2023-11-06T12:58:42Z\&quot;,\n          \&quot;channel\&quot;: {\n            \&quot;id\&quot;: \&quot;47b4ac3a-517c-11ee-b3ff-0a58a9feac02\&quot;\n          }\n        }\n      ],\n      \&quot;send_notifications\&quot;: false,\n      \&quot;severity\&quot;: {\n        \&quot;id\&quot;: \&quot;8ec16f86-0c1d-11ee-9def-0a58a9feac02\&quot;\n      },\n      \&quot;objects\&quot;: [\n        {\n          \&quot;id\&quot;: \&quot;line:IDFM:C00224\&quot;,\n          \&quot;type\&quot;: \&quot;line\&quot;\n        },\n        {\n          \&quot;id\&quot;: \&quot;stop_area:IDFM:63978\&quot;,\n          \&quot;type\&quot;: \&quot;stop_area\&quot;\n        },\n        {\n          \&quot;id\&quot;: \&quot;stop_point:IDFM:31481\&quot;,\n          \&quot;type\&quot;: \&quot;stop_point\&quot;\n        },\n        {\n          \&quot;id\&quot;: \&quot;network:IDFM:Operator_043\&quot;,\n          \&quot;type\&quot;: \&quot;network\&quot;\n        },\n        {\n          \&quot;id\&quot;: \&quot;katalon_line_section_deviation\&quot;,\n          \&quot;type\&quot;: \&quot;line_section\&quot;,\n          \&quot;line_section\&quot;: {\n            \&quot;start_point\&quot;: {\n              \&quot;id\&quot;: \&quot;stop_area:IDFM:488494\&quot;,\n              \&quot;type\&quot;: \&quot;stop_area\&quot;\n            },\n            \&quot;end_point\&quot;: {\n              \&quot;id\&quot;: \&quot;stop_area:IDFM:488494\&quot;,\n              \&quot;type\&quot;: \&quot;stop_area\&quot;\n            },\n            \&quot;line\&quot;: {\n              \&quot;id\&quot;: \&quot;line:IDFM:C00224\&quot;,\n              \&quot;type\&quot;: \&quot;line\&quot;\n            },\n            \&quot;routes\&quot;: [\n              {\n                \&quot;id\&quot;: \&quot;route:IDFM:KRO6:C00224-99-A\&quot;,\n                \&quot;type\&quot;: \&quot;route\&quot;\n              }\n            ]\n          }\n        },\n        {\n          \&quot;id\&quot;: \&quot;katalon_line_section\&quot;,\n          \&quot;type\&quot;: \&quot;line_section\&quot;,\n          \&quot;line_section\&quot;: {\n            \&quot;start_point\&quot;: {\n              \&quot;id\&quot;: \&quot;stop_area:IDFM:66535\&quot;,\n              \&quot;type\&quot;: \&quot;stop_area\&quot;\n            },\n            \&quot;end_point\&quot;: {\n              \&quot;id\&quot;: \&quot;stop_area:IDFM:66632\&quot;,\n              \&quot;type\&quot;: \&quot;stop_area\&quot;\n            },\n            \&quot;line\&quot;: {\n              \&quot;id\&quot;: \&quot;line:IDFM:C00224\&quot;,\n              \&quot;type\&quot;: \&quot;line\&quot;\n            }\n          }\n        },\n        {\n          \&quot;id\&quot;: \&quot;poi:14748\&quot;,\n          \&quot;type\&quot;: \&quot;poi\&quot;\n        },\n        {\n          \&quot;id\&quot;: \&quot;vehicle_journey:IDFM:TRANSDEV_VERSAILLES:113787-C00693-17214967\&quot;,\n          \&quot;type\&quot;: \&quot;vehicle_journey\&quot;\n        },\n        {\n          \&quot;id\&quot;: \&quot;access_point:IDFM:StopPlaceEntrance:50148043\&quot;,\n          \&quot;type\&quot;: \&quot;access_point\&quot;,\n          \&quot;access_point\&quot;: {\n            \&quot;stop_point\&quot;: {\n              \&quot;id\&quot;: \&quot;stop_point:IDFM:463129\&quot;,\n              \&quot;type\&quot;: \&quot;stop_point\&quot;\n            }\n          }\n        },\n        {\n          \&quot;id\&quot;: \&quot;katalon_rail_section\&quot;,\n          \&quot;type\&quot;: \&quot;rail_section\&quot;,\n          \&quot;rail_section\&quot;: {\n            \&quot;line\&quot;: {\n              \&quot;id\&quot;: \&quot;line:IDFM:C01390\&quot;,\n              \&quot;type\&quot;: \&quot;line\&quot;\n            },\n            \&quot;start_point\&quot;: {\n              \&quot;id\&quot;: \&quot;stop_area:IDFM:70587\&quot;,\n              \&quot;type\&quot;: \&quot;stop_area\&quot;\n            },\n            \&quot;end_point\&quot;: {\n              \&quot;id\&quot;: \&quot;stop_area:IDFM:70692\&quot;,\n              \&quot;type\&quot;: \&quot;stop_area\&quot;\n            },\n            \&quot;blocked_stop_areas\&quot;: [\n              {\n                \&quot;id\&quot;: \&quot;stop_area:IDFM:70587\&quot;,\n                \&quot;order\&quot;: 7\n              },\n              {\n                \&quot;id\&quot;: \&quot;stop_area:IDFM:69533\&quot;,\n                \&quot;order\&quot;: 8\n              },\n              {\n                \&quot;id\&quot;: \&quot;stop_area:IDFM:70692\&quot;,\n                \&quot;order\&quot;: 9\n              }\n            ]\n          }\n        }\n      ],\n      \&quot;notification_date\&quot;: \&quot;2023-11-06T12:58:42Z\&quot;,\n      \&quot;application_periods\&quot;: [\n        {\n          \&quot;begin\&quot;: \&quot;2023-11-29T12:57:00Z\&quot;,\n          \&quot;end\&quot;: \&quot;2024-12-29T14:57:00Z\&quot;\n        }\n      ]\n    }\n  ],\n  \&quot;publication_period\&quot;: {\n    \&quot;begin\&quot;: \&quot;2023-11-29T12:57:00Z\&quot;,\n    \&quot;end\&quot;: \&quot;2024-12-29T14:57:00Z\&quot;\n  }\n}&quot;,
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
   <restRequestMethod>POST</restRequestMethod>
   <restUrl>${GlobalVariable.base_url}/disruptions</restUrl>
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
