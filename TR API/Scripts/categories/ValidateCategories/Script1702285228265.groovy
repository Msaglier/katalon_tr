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

WS.comment('NOK : https://navitia.atlassian.net/jira/software/c/projects/BO/issues/BO-2789')

'I create a Category'
response = WS.sendRequest(findTestObject('Categories/PostCategory', [('x_customer') : GlobalVariable.x_customer_id, ('x_coverage') : GlobalVariable.x_coverage
            , ('x_contributor') : GlobalVariable.x_contributors, ('authorization') : GlobalVariable.authorization]))

'I receive a code 201 : creation OK.'
WS.verifyResponseStatusCode(response, 201)

'I verify that I have a value "katalon_category_post" for my category name.'
WS.verifyElementPropertyValue(response, 'category.name', 'katalon_category_post')

'I save the category Uuid'
category_id = WS.getElementPropertyValue(response, 'category.id')

'I get the specific category'
get_response = WS.sendRequest(findTestObject('Categories/GetSpecificCategory', [('x_customer') : GlobalVariable.x_customer_id
            , ('x_coverage') : GlobalVariable.x_coverage, ('x_contributor') : GlobalVariable.x_contributors, ('authorization') : GlobalVariable.authorization
            , ('category_id') : category_id]))

'I receive a code 200 : this category exists.'
WS.verifyResponseStatusCode(get_response, 200)

'I edit the name of this specific category.'
put_response = WS.sendRequest(findTestObject('Categories/PutSpecificCategory', [('x_customer') : GlobalVariable.x_customer_id
            , ('x_coverage') : GlobalVariable.x_coverage, ('x_contributor') : GlobalVariable.x_contributors, ('authorization') : GlobalVariable.authorization
            , ('category_id') : category_id]))

'I receive a code 200 : this category has been edited.'
WS.verifyResponseStatusCode(put_response, 200)

'I verify that I have "katalon_cause_without_category_put"  as name for my category.'
WS.verifyElementPropertyValue(put_response, 'category.name', 'katalon_category_put')

'I delete this specific category.'
delete_response = WS.sendRequest(findTestObject('Categories/DeleteSpecificCategory', [('x_customer') : GlobalVariable.x_customer_id
            , ('x_coverage') : GlobalVariable.x_coverage, ('x_contributor') : GlobalVariable.x_contributors, ('authorization') : GlobalVariable.authorization
            , ('category_id') : category_id]))

'I receive a code 204 : this category has been deleted.'
WS.verifyResponseStatusCode(delete_response, 204)

