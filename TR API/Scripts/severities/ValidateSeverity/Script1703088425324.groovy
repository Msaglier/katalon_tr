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

'I create a Severity'
response = WS.sendRequest(findTestObject('severities/PostSeverity', [('x_customer') : GlobalVariable.x_customer_id, ('x_coverage') : GlobalVariable.x_coverage
            , ('x_contributor') : GlobalVariable.x_contributors, ('authorization') : GlobalVariable.authorization]))

'I receive a code 201 : creation OK.'
WS.verifyResponseStatusCode(response, 201)

'I verify that I have the wording at "katalon_severity_post".'
WS.verifyElementPropertyValue(response, 'severity.wording', 'katalon_severity_post')

'I save the severity Uuid'
severity_id = WS.getElementPropertyValue(response, 'severity.id')

'I get the specific severity'
get_response = WS.sendRequest(findTestObject('severities/GetSeverity', [('x_customer') : GlobalVariable.x_customer_id, ('x_coverage') : GlobalVariable.x_coverage
            , ('x_contributor') : GlobalVariable.x_contributors, ('authorization') : GlobalVariable.authorization, ('severity_id') : severity_id]))

'I receive a code 200 : this severity exists.'
WS.verifyResponseStatusCode(get_response, 200)

'I put this specific severity with a new value for wordings'
put_response = WS.sendRequest(findTestObject('severities/PutSeverity', [('x_customer') : GlobalVariable.x_customer_id, ('x_coverage') : GlobalVariable.x_coverage
            , ('x_contributor') : GlobalVariable.x_contributors, ('authorization') : GlobalVariable.authorization, ('severity_id') : severity_id]))

'I receive a code 200 : this severity has been edited.'
WS.verifyResponseStatusCode(put_response, 200)

'I verify that I have a value "katalon_severity_put" for Key.'
WS.verifyElementPropertyValue(put_response, 'severity.wording', 'katalon_severity_put')

'I delete this specific severity'
delete_response = WS.sendRequest(findTestObject('severities/DeleteSeverity', [('x_customer') : GlobalVariable.x_customer_id
            , ('x_coverage') : GlobalVariable.x_coverage, ('x_contributor') : GlobalVariable.x_contributors, ('authorization') : GlobalVariable.authorization
            , ('severity_id') : severity_id]))

'I receive a code 204 : this severity has been deleted.'
WS.verifyResponseStatusCode(delete_response, 204)

