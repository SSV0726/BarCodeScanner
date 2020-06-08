# BarCodeScanner

** mainactivity -> scancode -> resultactivity -
**                   ^________________________|


- In result_activity , we recive and intent which has barcode , we call function add to list which 
appends that barcode into listItems , and it is displayed on the screen , which happens all offline 

now to calculate price and image prodname we are giving a call inside the same function and as
soon as we recive the response we update it with the api calls data to calulate final result .