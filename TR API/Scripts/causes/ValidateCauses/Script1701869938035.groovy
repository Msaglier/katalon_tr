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

'I create a Cause without category'
response = WS.sendRequest(findTestObject('causes/PostCausesWithoutCategory'))

'I receive a code 201 : creation OK.'
WS.verifyResponseStatusCode(response, 201)

'I verify that I have a value "katalon_cause_without_category_post" for my external_long wording key.'
WS.verifyElementPropertyValue(response, 'cause.wordings[0].value', 'katalon_cause_without_category_post')

'I save the cause Uuid'
cause_id = WS.getElementPropertyValue(response, 'cause.id')

'I get the specific cause'
get_response = WS.sendRequest(findTestObject('causes/GetSpecificCause', [('x_customer') : GlobalVariable.x_customer_id
            , ('x_coverage') : GlobalVariable.x_coverage, ('x_contributor') : GlobalVariable.x_contributors, ('authorization') : GlobalVariable.authorization
            , ('cause_id') : cause_id]))

println("Response is : $get_response")

println("cause_id is : $cause_id")

'I receive a code 200 : this cause exists.'
WS.verifyResponseStatusCode(get_response, 200)

'I put this specific cause with a new external_long wording value.'
put_response = WS.sendRequest(findTestObject('causes/PutSpecificCauseWithoutCategory', [('x_customer') : GlobalVariable.x_customer_id
            , ('x_coverage') : GlobalVariable.x_coverage, ('x_contributor') : GlobalVariable.x_contributors, ('authorization') : GlobalVariable.authorization
            , ('cause_id') : cause_id]))

'I receive a code 200 : this cause has been edited.'
WS.verifyResponseStatusCode(get_response, 200)

'I verify that I have a value "katalon_cause_without_category_put" for my external_long wording key.'
WS.verifyElementPropertyValue(put_response, 'cause.wordings[0].value', 'katalon_cause_without_category_put')

'I delete this specific cause.'
delete_response = WS.sendRequest(findTestObject('causes/DeleteSpecificCause', [('x_customer') : GlobalVariable.x_customer_id
            , ('x_coverage') : GlobalVariable.x_coverage, ('x_contributor') : GlobalVariable.x_contributors, ('authorization') : GlobalVariable.authorization
            , ('cause_id') : cause_id]))

'I receive a code 204 : this cause has been deleted.'
WS.verifyResponseStatusCode(delete_response, 204)

