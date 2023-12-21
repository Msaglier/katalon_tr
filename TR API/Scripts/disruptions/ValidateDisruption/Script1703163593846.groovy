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
response = WS.sendRequest(findTestObject('disruptions/PostDisruptionOneImpactAllTypes', [('x_customer') : GlobalVariable.x_customer_id, ('x_coverage') : GlobalVariable.x_coverage
            , ('x_contributor') : GlobalVariable.x_contributors, ('authorization') : GlobalVariable.authorization]))

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

'I put this specific disruption with a new reference.'
put_response = WS.sendRequest(findTestObject('disruptions/PutDisruptionOneImpactAllTypes', [('x_customer') : GlobalVariable.x_customer_id
            , ('x_coverage') : GlobalVariable.x_coverage, ('x_contributor') : GlobalVariable.x_contributors, ('authorization') : GlobalVariable.authorization
            , ('disruption_id') : disruption_id]))

'I receive a code 200 : this disruption has been edited.'
WS.verifyResponseStatusCode(put_response, 200)

'I verify that I have a value "katalon_tag_put" for Name.'
WS.verifyElementPropertyValue(put_response, 'disruption.reference', 'katalon_disruption_put')

'I delete this specific disruption'
delete_response = WS.sendRequest(findTestObject('disruptions/DeleteDisruption', [('x_customer') : GlobalVariable.x_customer_id
            , ('x_coverage') : GlobalVariable.x_coverage, ('x_contributor') : GlobalVariable.x_contributors, ('authorization') : GlobalVariable.authorization
            , ('disruption_id') : disruption_id]))

'I receive a code 204 : this disruption has been deleted.'
WS.verifyResponseStatusCode(delete_response, 204)

