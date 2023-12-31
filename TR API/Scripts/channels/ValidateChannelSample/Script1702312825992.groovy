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

'I create a Channel, nominal case'
response = WS.sendRequest(findTestObject('channels/PostChannelSample', [('x_customer') : GlobalVariable.x_customer_id, ('x_coverage') : GlobalVariable.x_coverage
            , ('x_contributor') : GlobalVariable.x_contributors, ('authorization') : GlobalVariable.authorization]))

'I receive a code 201 : creation OK.'
WS.verifyResponseStatusCode(response, 201)

'I verify that I have "katalon_channel_post" as channel name.'
WS.verifyElementPropertyValue(response, 'channel.name', 'katalon_channel_post')

'I save the channel Uuid'
channel_id = WS.getElementPropertyValue(response, 'channel.id')

'I get the specific channel'
get_response = WS.sendRequest(findTestObject('channels/GetSpecificChannel', [('x_customer') : GlobalVariable.x_customer_id
            , ('x_coverage') : GlobalVariable.x_coverage, ('x_contributor') : GlobalVariable.x_contributors, ('authorization') : GlobalVariable.authorization
            , ('channel_id') : channel_id]))

'I receive a code 200 : this channel exists.'
WS.verifyResponseStatusCode(get_response, 200)

'I put this specific channel with a new name.'
put_response = WS.sendRequest(findTestObject('channels/PutSpecificChannel', [('x_customer') : GlobalVariable.x_customer_id
            , ('x_coverage') : GlobalVariable.x_coverage, ('x_contributor') : GlobalVariable.x_contributors, ('authorization') : GlobalVariable.authorization
            , ('channel_id') : channel_id]))

'I receive a code 200 : this channel has been edited.'
WS.verifyResponseStatusCode(put_response, 200)

'I verify that I have a value "katalon_channel_put" for name.'
WS.verifyElementPropertyValue(put_response, 'channel.name', 'katalon_channel_put')

'I delete this specific channel.'
delete_response = WS.sendRequest(findTestObject('channels/DeleteSpecificChannel', [('x_customer') : GlobalVariable.x_customer_id
            , ('x_coverage') : GlobalVariable.x_coverage, ('x_contributor') : GlobalVariable.x_contributors, ('authorization') : GlobalVariable.authorization
            , ('channel_id') : channel_id]))

'I receive a code 204 : this channel has been deleted.'
WS.verifyResponseStatusCode(delete_response, 204)

