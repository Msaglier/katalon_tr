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

WebUI.comment('NOK - Same as Category: cant reuse a name.')

'I create a Tag'
response = WS.sendRequest(findTestObject('tags/PostTag', [('x_customer') : GlobalVariable.x_customer_id, ('x_coverage') : GlobalVariable.x_coverage
            , ('x_contributor') : GlobalVariable.x_contributors, ('authorization') : GlobalVariable.authorization]))

'I receive a code 201 : creation OK.'
WS.verifyResponseStatusCode(response, 201)

'I verify that I have the wording at "katalon_tag_post".'
WS.verifyElementPropertyValue(response, 'tag.name', 'katalon_tag_post')

'I save the tag Uuid'
tag_id = WS.getElementPropertyValue(response, 'tag.id')

'I get the specific tag'
get_response = WS.sendRequest(findTestObject('tags/GetTag', [('x_customer') : GlobalVariable.x_customer_id, ('x_coverage') : GlobalVariable.x_coverage
            , ('x_contributor') : GlobalVariable.x_contributors, ('authorization') : GlobalVariable.authorization, ('tag_id') : tag_id]))

'I receive a code 200 : this tag exists.'
WS.verifyResponseStatusCode(get_response, 200)

'I put this specific tag with a new value for name'
put_response = WS.sendRequest(findTestObject('tags/PutTag', [('x_customer') : GlobalVariable.x_customer_id, ('x_coverage') : GlobalVariable.x_coverage
            , ('x_contributor') : GlobalVariable.x_contributors, ('authorization') : GlobalVariable.authorization, ('tag_id') : tag_id]))

'I receive a code 200 : this severity has been edited.'
WS.verifyResponseStatusCode(put_response, 200)

'I verify that I have a value "katalon_tag_put" for Name.'
WS.verifyElementPropertyValue(put_response, 'tag.name', 'katalon_tag_put')

'I delete this specific tag'
delete_response = WS.sendRequest(findTestObject('tags/DeleteTag', [('x_customer') : GlobalVariable.x_customer_id, ('x_coverage') : GlobalVariable.x_coverage
            , ('x_contributor') : GlobalVariable.x_contributors, ('authorization') : GlobalVariable.authorization, ('tag_id') : tag_id]))

'I receive a code 204 : this tag has been deleted.'
WS.verifyResponseStatusCode(delete_response, 204)

