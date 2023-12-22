import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

'I create a Disruption'
response = WS.sendRequest(findTestObject('disruptions/PostDisruptionOneImpactAllTypes', [('x_customer') : GlobalVariable.x_customer_id
            , ('x_coverage') : GlobalVariable.x_coverage, ('x_contributor') : GlobalVariable.x_contributors, ('authorization') : GlobalVariable.authorization]))

'I receive a code 201 : creation OK.'
WS.verifyResponseStatusCode(response, 201)

'I verify that I have "katalon_disruption_post" as reference.'
WS.verifyElementPropertyValue(response, 'disruption.reference', 'katalon_disruption_post')

'I save the disruption Uuid'
disruption_id = WS.getElementPropertyValue(response, 'disruption.id')

'I get the specific disruption'
get_response = WS.sendRequest(findTestObject('disruptions/GetDisruption', [('x_customer') : GlobalVariable.x_customer_id
            , ('x_coverage') : GlobalVariable.x_coverage, ('x_contributor') : GlobalVariable.x_contributors, ('authorization') : GlobalVariable.authorization
            , ('disruption_id') : disruption_id]))

'I receive a code 200 : this disruption exists.'
WS.verifyResponseStatusCode(get_response, 200)

'I save the impact_id Uuid'
impact_id_1 = WS.getElementPropertyValue(get_response, 'disruption.impacts.impacts[0].id')

'I get the specific impact'
get_response_impact_1 = WS.sendRequest(findTestObject('impacts/GetImpact', [('x_customer') : GlobalVariable.x_customer_id
            , ('x_coverage') : GlobalVariable.x_coverage, ('x_contributor') : GlobalVariable.x_contributors, ('authorization') : GlobalVariable.authorization
            , ('disruption_id') : disruption_id, ('impact_id') : impact_id_1]))

'I receive a code 200 : this impact exists.'
WS.verifyResponseStatusCode(get_response_impact_1, 200)

'I put this specific impact with a new channel_msg'
put_response_impact_1 = WS.sendRequest(findTestObject('impacts/PutImpact', [('x_customer') : GlobalVariable.x_customer_id
            , ('x_coverage') : GlobalVariable.x_coverage, ('x_contributor') : GlobalVariable.x_contributors, ('authorization') : GlobalVariable.authorization
            , ('disruption_id') : disruption_id, ('impact_id') : impact_id_1]))

'I receive a code 200 : this impact has been edited.'
WS.verifyResponseStatusCode(put_response_impact_1, 200)

'I verify that I have a value "katalon_impact_put" as message'
WS.verifyElementPropertyValue(put_response_impact_1, 'impact.messages[0].text', 'katalon_impact_PUT')

'I post a new impact for this disruption.'
post_response_impact_2 = WS.sendRequest(findTestObject('impacts/PostImpact', [('x_customer') : GlobalVariable.x_customer_id
            , ('x_coverage') : GlobalVariable.x_coverage, ('x_contributor') : GlobalVariable.x_contributors, ('authorization') : GlobalVariable.authorization
            , ('disruption_id') : disruption_id]))

'I receive a code 200 : this second impact exists.'
WS.verifyResponseStatusCode(post_response_impact_2, 201)

'I save the impact_id Uuid'
impact_id_2 = WS.getElementPropertyValue(post_response_impact_2, 'impact.id')

'I delete the first impact'
delete_response_impact_1 = WS.sendRequest(findTestObject('impacts/DeleteImpact', [('x_customer') : GlobalVariable.x_customer_id
            , ('x_coverage') : GlobalVariable.x_coverage, ('x_contributor') : GlobalVariable.x_contributors, ('authorization') : GlobalVariable.authorization
            , ('disruption_id') : disruption_id, ('impact_id') : impact_id_1]))

'I receive a code 204 : this disruption has been deleted.'
WS.verifyResponseStatusCode(delete_response_impact_1, 204)

'I get the specific impact'
get_response_impact_1bis = WS.sendRequest(findTestObject('impacts/GetImpact', [('x_customer') : GlobalVariable.x_customer_id
            , ('x_coverage') : GlobalVariable.x_coverage, ('x_contributor') : GlobalVariable.x_contributors, ('authorization') : GlobalVariable.authorization
            , ('disruption_id') : disruption_id, ('impact_id') : impact_id_1]))

'I receive a code 404 : this impact doesnt exist anymore.'
WS.verifyResponseStatusCode(get_response_impact_1bis, 404)

'I get the second impact'
get_response_impact_2 = WS.sendRequest(findTestObject('impacts/GetImpact', [('x_customer') : GlobalVariable.x_customer_id
            , ('x_coverage') : GlobalVariable.x_coverage, ('x_contributor') : GlobalVariable.x_contributors, ('authorization') : GlobalVariable.authorization
            , ('disruption_id') : disruption_id, ('impact_id') : impact_id_2]))

'I receive a code 200 : the second impact still exists.'
WS.verifyResponseStatusCode(get_response_impact_2, 200)

'I delete the whole disruption.'
delete_response = WS.sendRequest(findTestObject('disruptions/DeleteDisruption', [('x_customer') : GlobalVariable.x_customer_id
            , ('x_coverage') : GlobalVariable.x_coverage, ('x_contributor') : GlobalVariable.x_contributors, ('authorization') : GlobalVariable.authorization
            , ('disruption_id') : disruption_id]))

'I receive a code 204 : this disruption has been deleted.'
WS.verifyResponseStatusCode(delete_response, 204)

