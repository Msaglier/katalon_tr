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

'I create a Property'
response = WS.sendRequest(findTestObject('properties/PostProperty', [('x_customer') : GlobalVariable.x_customer_id, ('x_coverage') : GlobalVariable.x_coverage
            , ('x_contributor') : GlobalVariable.x_contributors, ('authorization') : GlobalVariable.authorization]))

'I receive a code 201 : creation OK.'
WS.verifyResponseStatusCode(response, 201)

'I verify that I have a key "katalon_property_post".'
WS.verifyElementPropertyValue(response, 'property.key', 'katalon_property_post')

'I save the property Uuid'
property_id = WS.getElementPropertyValue(response, 'property.id')

'I get the specific property'
get_response = WS.sendRequest(findTestObject('properties/GetProperty', [('x_customer') : GlobalVariable.x_customer_id, ('x_coverage') : GlobalVariable.x_coverage
            , ('x_contributor') : GlobalVariable.x_contributors, ('authorization') : GlobalVariable.authorization, ('property_id') : property_id]))

'I receive a code 200 : this property exists.'
WS.verifyResponseStatusCode(get_response, 200)

'I put this specific property with a new value for Key.'
put_response = WS.sendRequest(findTestObject('properties/PutProperty', [('x_customer') : GlobalVariable.x_customer_id, ('x_coverage') : GlobalVariable.x_coverage
            , ('x_contributor') : GlobalVariable.x_contributors, ('authorization') : GlobalVariable.authorization, ('property_id') : property_id]))

'I receive a code 200 : this property has been edited.'
WS.verifyResponseStatusCode(put_response, 200)

'I verify that I have a value "katalon_property_put" for Key.'
WS.verifyElementPropertyValue(put_response, 'property.key', 'katalon_property_put')

'I delete this specific property.'
delete_response = WS.sendRequest(findTestObject('properties/DeleteProperty', [('x_customer') : GlobalVariable.x_customer_id
            , ('x_coverage') : GlobalVariable.x_coverage, ('x_contributor') : GlobalVariable.x_contributors, ('authorization') : GlobalVariable.authorization
            , ('property_id') : property_id]))

'I receive a code 204 : this property has been deleted.'
WS.verifyResponseStatusCode(delete_response, 204)

