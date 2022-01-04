# Api Documentation

**简介**:res_conf 素材投放动态配置中心

**HOST**:http://localhost:8083


**联系人**:

**Version**:1.0


**接口路径**:/v3/api-docs


[TOC]




# 资源位素材统一对外API接口


## query


**接口地址**:`/api/delivery/query`


**请求方式**:`POST`


**请求数据类型**:`application/x-www-form-urlencoded,application/json`


**响应数据类型**:`*/*`


**接口描述**:


**请求示例**:


```javascript
{
  "classify": "",
  "code": "",
  "creater": "",
  "depart": "",
  "isAsc": "",
  "isDeleted": 0,
  "metaValue": "",
  "name": "",
  "orderByColumn": "",
  "pageNum": 0,
  "pageSize": 0,
  "platformCode": "",
  "platformName": "",
  "searchYourself": 0,
  "siteCode": "",
  "siteName": "",
  "strategy": "",
  "updater": ""
}
```


**请求参数**:


| 参数名称                   | 参数说明           | 请求类型 | 是否必须 | 数据类型           | schema             |
| -------------------------- | ------------------ | -------- | -------- | ------------------ | ------------------ |
| resourcenicheQuery         | ResourcenicheQuery | body     | true     | ResourcenicheQuery | ResourcenicheQuery |
| &emsp;&emsp;classify       |                    |          | false    | string             |                    |
| &emsp;&emsp;code           |                    |          | false    | string             |                    |
| &emsp;&emsp;creater        |                    |          | false    | string             |                    |
| &emsp;&emsp;depart         |                    |          | false    | string             |                    |
| &emsp;&emsp;isAsc          |                    |          | false    | string             |                    |
| &emsp;&emsp;isDeleted      |                    |          | false    | integer(int32)     |                    |
| &emsp;&emsp;metaValue      |                    |          | false    | string             |                    |
| &emsp;&emsp;name           |                    |          | false    | string             |                    |
| &emsp;&emsp;orderByColumn  |                    |          | false    | string             |                    |
| &emsp;&emsp;pageNum        |                    |          | false    | integer(int32)     |                    |
| &emsp;&emsp;pageSize       |                    |          | false    | integer(int32)     |                    |
| &emsp;&emsp;platformCode   |                    |          | false    | string             |                    |
| &emsp;&emsp;platformName   |                    |          | false    | string             |                    |
| &emsp;&emsp;searchYourself |                    |          | false    | integer(int32)     |                    |
| &emsp;&emsp;siteCode       |                    |          | false    | string             |                    |
| &emsp;&emsp;siteName       |                    |          | false    | string             |                    |
| &emsp;&emsp;strategy       |                    |          | false    | string             |                    |
| &emsp;&emsp;updater        |                    |          | false    | string             |                    |


**响应状态**:


| 状态码 | 说明         | schema    |
| ------ | ------------ | --------- |
| 200    | OK           | ResResult |
| 201    | Created      |           |
| 401    | Unauthorized |           |
| 403    | Forbidden    |           |
| 404    | Not Found    |           |


**响应参数**:


| 参数名称 | 参数说明 | 类型    | schema |
| -------- | -------- | ------- | ------ |
| code     |          | string  |        |
| msg      |          | string  |        |
| success  |          | boolean |        |
| value    |          | object  |        |


**响应示例**:

```javascript
{
	"code": "",
	"msg": "",
	"success": true,
	"value": {}
}
```


# 资源位管理


## addSave


**接口地址**:`/api/admin/delivery/add`


**请求方式**:`POST`


**请求数据类型**:`application/x-www-form-urlencoded,application/json`


**响应数据类型**:`*/*`


**接口描述**:


**请求示例**:


```javascript
{
  "classify": "",
  "code": "",
  "created": 0,
  "creater": "",
  "depart": "",
  "describe": "",
  "id": 0,
  "isDeleted": 0,
  "metaValue": "",
  "name": "",
  "platformCode": "",
  "platformName": "",
  "recordOnlineTotal": 0,
  "recordTotal": 0,
  "strategy": "",
  "templateCode": "",
  "updated": 0,
  "updater": ""
}
```


**请求参数**:


| 参数名称                      | 参数说明         | 请求类型 | 是否必须 | 数据类型         | schema           |
| ----------------------------- | ---------------- | -------- | -------- | ---------------- | ---------------- |
| resourcenicheReq              | ResourcenicheReq | body     | true     | ResourcenicheReq | ResourcenicheReq |
| &emsp;&emsp;classify          |                  |          | true     | string           |                  |
| &emsp;&emsp;code              |                  |          | false    | string           |                  |
| &emsp;&emsp;created           |                  |          | false    | integer(int32)   |                  |
| &emsp;&emsp;creater           |                  |          | false    | string           |                  |
| &emsp;&emsp;depart            |                  |          | false    | string           |                  |
| &emsp;&emsp;describe          |                  |          | false    | string           |                  |
| &emsp;&emsp;id                |                  |          | true     | integer(int64)   |                  |
| &emsp;&emsp;isDeleted         |                  |          | false    | integer(int32)   |                  |
| &emsp;&emsp;metaValue         |                  |          | false    | string           |                  |
| &emsp;&emsp;name              |                  |          | true     | string           |                  |
| &emsp;&emsp;platformCode      |                  |          | false    | string           |                  |
| &emsp;&emsp;platformName      |                  |          | false    | string           |                  |
| &emsp;&emsp;recordOnlineTotal |                  |          | false    | integer(int32)   |                  |
| &emsp;&emsp;recordTotal       |                  |          | false    | integer(int32)   |                  |
| &emsp;&emsp;strategy          |                  |          | false    | string           |                  |
| &emsp;&emsp;templateCode      |                  |          | false    | string           |                  |
| &emsp;&emsp;updated           |                  |          | false    | integer(int32)   |                  |
| &emsp;&emsp;updater           |                  |          | false    | string           |                  |


**响应状态**:


| 状态码 | 说明         | schema    |
| ------ | ------------ | --------- |
| 200    | OK           | ResResult |
| 201    | Created      |           |
| 401    | Unauthorized |           |
| 403    | Forbidden    |           |
| 404    | Not Found    |           |


**响应参数**:


| 参数名称 | 参数说明 | 类型    | schema |
| -------- | -------- | ------- | ------ |
| code     |          | string  |        |
| msg      |          | string  |        |
| success  |          | boolean |        |
| value    |          | object  |        |


**响应示例**:

```javascript
{
	"code": "",
	"msg": "",
	"success": true,
	"value": {}
}
```


## editSave


**接口地址**:`/api/admin/delivery/edit`


**请求方式**:`POST`


**请求数据类型**:`application/x-www-form-urlencoded,application/json`


**响应数据类型**:`*/*`


**接口描述**:


**请求示例**:


```javascript
{
  "classify": "",
  "code": "",
  "created": 0,
  "creater": "",
  "depart": "",
  "describe": "",
  "id": 0,
  "isDeleted": 0,
  "metaValue": "",
  "name": "",
  "platformCode": "",
  "platformName": "",
  "recordOnlineTotal": 0,
  "recordTotal": 0,
  "strategy": "",
  "templateCode": "",
  "updated": 0,
  "updater": ""
}
```


**请求参数**:


| 参数名称                      | 参数说明         | 请求类型 | 是否必须 | 数据类型         | schema           |
| ----------------------------- | ---------------- | -------- | -------- | ---------------- | ---------------- |
| resourcenicheReq              | ResourcenicheReq | body     | true     | ResourcenicheReq | ResourcenicheReq |
| &emsp;&emsp;classify          |                  |          | true     | string           |                  |
| &emsp;&emsp;code              |                  |          | false    | string           |                  |
| &emsp;&emsp;created           |                  |          | false    | integer(int32)   |                  |
| &emsp;&emsp;creater           |                  |          | false    | string           |                  |
| &emsp;&emsp;depart            |                  |          | false    | string           |                  |
| &emsp;&emsp;describe          |                  |          | false    | string           |                  |
| &emsp;&emsp;id                |                  |          | true     | integer(int64)   |                  |
| &emsp;&emsp;isDeleted         |                  |          | false    | integer(int32)   |                  |
| &emsp;&emsp;metaValue         |                  |          | false    | string           |                  |
| &emsp;&emsp;name              |                  |          | true     | string           |                  |
| &emsp;&emsp;platformCode      |                  |          | false    | string           |                  |
| &emsp;&emsp;platformName      |                  |          | false    | string           |                  |
| &emsp;&emsp;recordOnlineTotal |                  |          | false    | integer(int32)   |                  |
| &emsp;&emsp;recordTotal       |                  |          | false    | integer(int32)   |                  |
| &emsp;&emsp;strategy          |                  |          | false    | string           |                  |
| &emsp;&emsp;templateCode      |                  |          | false    | string           |                  |
| &emsp;&emsp;updated           |                  |          | false    | integer(int32)   |                  |
| &emsp;&emsp;updater           |                  |          | false    | string           |                  |


**响应状态**:


| 状态码 | 说明         | schema    |
| ------ | ------------ | --------- |
| 200    | OK           | ResResult |
| 201    | Created      |           |
| 401    | Unauthorized |           |
| 403    | Forbidden    |           |
| 404    | Not Found    |           |


**响应参数**:


| 参数名称 | 参数说明 | 类型    | schema |
| -------- | -------- | ------- | ------ |
| code     |          | string  |        |
| msg      |          | string  |        |
| success  |          | boolean |        |
| value    |          | object  |        |


**响应示例**:

```javascript
{
	"code": "",
	"msg": "",
	"success": true,
	"value": {}
}
```


## get


**接口地址**:`/api/admin/delivery/get/{id}`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型 | 是否必须 | 数据类型       | schema |
| -------- | -------- | -------- | -------- | -------------- | ------ |
| id       | id       | path     | true     | integer(int64) |        |


**响应状态**:


| 状态码 | 说明         | schema                   |
| ------ | ------------ | ------------------------ |
| 200    | OK           | ResResult«Resourceniche» |
| 401    | Unauthorized |                          |
| 403    | Forbidden    |                          |
| 404    | Not Found    |                          |


**响应参数**:


| 参数名称                      | 参数说明 | 类型             | schema           |
| ----------------------------- | -------- | ---------------- | ---------------- |
| code                          |          | string           |                  |
| msg                           |          | string           |                  |
| success                       |          | boolean          |                  |
| value                         |          | ResourcenicheRes | ResourcenicheRes |
| &emsp;&emsp;cachePattern      |          | string           |                  |
| &emsp;&emsp;classify          |          | string           |                  |
| &emsp;&emsp;code              |          | string           |                  |
| &emsp;&emsp;created           |          | integer(int32)   |                  |
| &emsp;&emsp;creater           |          | string           |                  |
| &emsp;&emsp;depart            |          | string           |                  |
| &emsp;&emsp;describe          |          | string           |                  |
| &emsp;&emsp;id                |          | integer(int64)   |                  |
| &emsp;&emsp;isDeleted         |          | integer(int32)   |                  |
| &emsp;&emsp;metaValue         |          | string           |                  |
| &emsp;&emsp;name              |          | string           |                  |
| &emsp;&emsp;platformCode      |          | string           |                  |
| &emsp;&emsp;platformName      |          | string           |                  |
| &emsp;&emsp;recordOnlineTotal |          | integer(int32)   |                  |
| &emsp;&emsp;recordTotal       |          | integer(int32)   |                  |
| &emsp;&emsp;strategy          |          | string           |                  |
| &emsp;&emsp;templateCode      |          | string           |                  |
| &emsp;&emsp;updated           |          | integer(int32)   |                  |
| &emsp;&emsp;updater           |          | string           |                  |


**响应示例**:

```javascript
{
	"code": "",
	"msg": "",
	"success": true,
	"value": {
		"cachePattern": "",
		"classify": "",
		"code": "",
		"created": 0,
		"creater": "",
		"depart": "",
		"describe": "",
		"id": 0,
		"isDeleted": 0,
		"metaValue": "",
		"name": "",
		"platformCode": "",
		"platformName": "",
		"recordOnlineTotal": 0,
		"recordTotal": 0,
		"strategy": "",
		"templateCode": "",
		"updated": 0,
		"updater": ""
	}
}
```


## list


**接口地址**:`/api/admin/delivery/list`


**请求方式**:`POST`


**请求数据类型**:`application/x-www-form-urlencoded,application/json`


**响应数据类型**:`*/*`


**接口描述**:


**请求示例**:


```javascript
{
  "classify": "",
  "code": "",
  "creater": "",
  "depart": "",
  "isAsc": "",
  "isDeleted": 0,
  "metaValue": "",
  "name": "",
  "orderByColumn": "",
  "pageNum": 0,
  "pageSize": 0,
  "platformCode": "",
  "platformName": "",
  "searchYourself": 0,
  "siteCode": "",
  "siteName": "",
  "strategy": "",
  "updater": ""
}
```


**请求参数**:


| 参数名称                   | 参数说明           | 请求类型 | 是否必须 | 数据类型           | schema             |
| -------------------------- | ------------------ | -------- | -------- | ------------------ | ------------------ |
| resourcenicheQuery         | ResourcenicheQuery | body     | true     | ResourcenicheQuery | ResourcenicheQuery |
| &emsp;&emsp;classify       |                    |          | false    | string             |                    |
| &emsp;&emsp;code           |                    |          | false    | string             |                    |
| &emsp;&emsp;creater        |                    |          | false    | string             |                    |
| &emsp;&emsp;depart         |                    |          | false    | string             |                    |
| &emsp;&emsp;isAsc          |                    |          | false    | string             |                    |
| &emsp;&emsp;isDeleted      |                    |          | false    | integer(int32)     |                    |
| &emsp;&emsp;metaValue      |                    |          | false    | string             |                    |
| &emsp;&emsp;name           |                    |          | false    | string             |                    |
| &emsp;&emsp;orderByColumn  |                    |          | false    | string             |                    |
| &emsp;&emsp;pageNum        |                    |          | false    | integer(int32)     |                    |
| &emsp;&emsp;pageSize       |                    |          | false    | integer(int32)     |                    |
| &emsp;&emsp;platformCode   |                    |          | false    | string             |                    |
| &emsp;&emsp;platformName   |                    |          | false    | string             |                    |
| &emsp;&emsp;searchYourself |                    |          | false    | integer(int32)     |                    |
| &emsp;&emsp;siteCode       |                    |          | false    | string             |                    |
| &emsp;&emsp;siteName       |                    |          | false    | string             |                    |
| &emsp;&emsp;strategy       |                    |          | false    | string             |                    |
| &emsp;&emsp;updater        |                    |          | false    | string             |                    |


**响应状态**:


| 状态码 | 说明         | schema        |
| ------ | ------------ | ------------- |
| 200    | OK           | TableDataInfo |
| 201    | Created      |               |
| 401    | Unauthorized |               |
| 403    | Forbidden    |               |
| 404    | Not Found    |               |


**响应参数**:


| 参数名称 | 参数说明 | 类型           | schema         |
| -------- | -------- | -------------- | -------------- |
| code     |          | integer(int32) | integer(int32) |
| msg      |          | string         |                |
| rows     |          | array          |                |
| total    |          | integer(int64) | integer(int64) |


**响应示例**:

```javascript
{
	"code": 0,
	"msg": "",
	"rows": [],
	"total": 0
}
```


## remove


**接口地址**:`/api/admin/delivery/remove`


**请求方式**:`POST`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型 | 是否必须 | 数据类型       | schema |
| -------- | -------- | -------- | -------- | -------------- | ------ |
| ids      | ids      | query    | true     | string         |        |
| logic    | logic    | query    | false    | integer(int32) |        |


**响应状态**:


| 状态码 | 说明         | schema    |
| ------ | ------------ | --------- |
| 200    | OK           | ResResult |
| 201    | Created      |           |
| 401    | Unauthorized |           |
| 403    | Forbidden    |           |
| 404    | Not Found    |           |


**响应参数**:


| 参数名称 | 参数说明 | 类型    | schema |
| -------- | -------- | ------- | ------ |
| code     |          | string  |        |
| msg      |          | string  |        |
| success  |          | boolean |        |
| value    |          | object  |        |


**响应示例**:

```javascript
{
	"code": "",
	"msg": "",
	"success": true,
	"value": {}
}
```


# 资源位-字段配置管理


## addSave


**接口地址**:`/api/admin/delivery/config/add`


**请求方式**:`POST`


**请求数据类型**:`application/x-www-form-urlencoded,application/json`


**响应数据类型**:`*/*`


**接口描述**:


**请求示例**:


```javascript
{
  "created": 0,
  "creater": "",
  "dataType": 0,
  "defaultValue": "",
  "depart": "",
  "editable": "",
  "id": 0,
  "isDeleted": 0,
  "metaKey": "",
  "metaName": "",
  "metaTips": "",
  "metaValue": "",
  "required": "",
  "resourceId": 0,
  "sort": 0,
  "updated": 0,
  "updater": ""
}
```


**请求参数**:


| 参数名称                 | 参数说明       | 请求类型 | 是否必须 | 数据类型       | schema         |
| ------------------------ | -------------- | -------- | -------- | -------------- | -------------- |
| resourceconfig           | Resourceconfig | body     | true     | Resourceconfig | Resourceconfig |
| &emsp;&emsp;created      |                |          | false    | integer(int32) |                |
| &emsp;&emsp;creater      |                |          | false    | string         |                |
| &emsp;&emsp;dataType     |                |          | true     | integer(int64) |                |
| &emsp;&emsp;defaultValue |                |          | false    | string         |                |
| &emsp;&emsp;depart       |                |          | false    | string         |                |
| &emsp;&emsp;editable     |                |          | false    | string         |                |
| &emsp;&emsp;id           |                |          | true     | integer(int64) |                |
| &emsp;&emsp;isDeleted    |                |          | false    | integer(int32) |                |
| &emsp;&emsp;metaKey      |                |          | true     | string         |                |
| &emsp;&emsp;metaName     |                |          | true     | string         |                |
| &emsp;&emsp;metaTips     |                |          | false    | string         |                |
| &emsp;&emsp;metaValue    |                |          | false    | string         |                |
| &emsp;&emsp;required     |                |          | false    | string         |                |
| &emsp;&emsp;resourceId   |                |          | true     | integer(int64) |                |
| &emsp;&emsp;sort         |                |          | false    | integer(int32) |                |
| &emsp;&emsp;updated      |                |          | false    | integer(int32) |                |
| &emsp;&emsp;updater      |                |          | false    | string         |                |


**响应状态**:


| 状态码 | 说明         | schema    |
| ------ | ------------ | --------- |
| 200    | OK           | ResResult |
| 201    | Created      |           |
| 401    | Unauthorized |           |
| 403    | Forbidden    |           |
| 404    | Not Found    |           |


**响应参数**:


| 参数名称 | 参数说明 | 类型    | schema |
| -------- | -------- | ------- | ------ |
| code     |          | string  |        |
| msg      |          | string  |        |
| success  |          | boolean |        |
| value    |          | object  |        |


**响应示例**:

```javascript
{
	"code": "",
	"msg": "",
	"success": true,
	"value": {}
}
```


## editSave


**接口地址**:`/api/admin/delivery/config/edit`


**请求方式**:`POST`


**请求数据类型**:`application/x-www-form-urlencoded,application/json`


**响应数据类型**:`*/*`


**接口描述**:


**请求示例**:


```javascript
{
  "created": 0,
  "creater": "",
  "dataType": 0,
  "defaultValue": "",
  "depart": "",
  "editable": "",
  "id": 0,
  "isDeleted": 0,
  "metaKey": "",
  "metaName": "",
  "metaTips": "",
  "metaValue": "",
  "required": "",
  "resourceId": 0,
  "sort": 0,
  "updated": 0,
  "updater": ""
}
```


**请求参数**:


| 参数名称                 | 参数说明       | 请求类型 | 是否必须 | 数据类型       | schema         |
| ------------------------ | -------------- | -------- | -------- | -------------- | -------------- |
| resourceconfig           | Resourceconfig | body     | true     | Resourceconfig | Resourceconfig |
| &emsp;&emsp;created      |                |          | false    | integer(int32) |                |
| &emsp;&emsp;creater      |                |          | false    | string         |                |
| &emsp;&emsp;dataType     |                |          | true     | integer(int64) |                |
| &emsp;&emsp;defaultValue |                |          | false    | string         |                |
| &emsp;&emsp;depart       |                |          | false    | string         |                |
| &emsp;&emsp;editable     |                |          | false    | string         |                |
| &emsp;&emsp;id           |                |          | true     | integer(int64) |                |
| &emsp;&emsp;isDeleted    |                |          | false    | integer(int32) |                |
| &emsp;&emsp;metaKey      |                |          | true     | string         |                |
| &emsp;&emsp;metaName     |                |          | true     | string         |                |
| &emsp;&emsp;metaTips     |                |          | false    | string         |                |
| &emsp;&emsp;metaValue    |                |          | false    | string         |                |
| &emsp;&emsp;required     |                |          | false    | string         |                |
| &emsp;&emsp;resourceId   |                |          | true     | integer(int64) |                |
| &emsp;&emsp;sort         |                |          | false    | integer(int32) |                |
| &emsp;&emsp;updated      |                |          | false    | integer(int32) |                |
| &emsp;&emsp;updater      |                |          | false    | string         |                |


**响应状态**:


| 状态码 | 说明         | schema    |
| ------ | ------------ | --------- |
| 200    | OK           | ResResult |
| 201    | Created      |           |
| 401    | Unauthorized |           |
| 403    | Forbidden    |           |
| 404    | Not Found    |           |


**响应参数**:


| 参数名称 | 参数说明 | 类型    | schema |
| -------- | -------- | ------- | ------ |
| code     |          | string  |        |
| msg      |          | string  |        |
| success  |          | boolean |        |
| value    |          | object  |        |


**响应示例**:

```javascript
{
	"code": "",
	"msg": "",
	"success": true,
	"value": {}
}
```


## list


**接口地址**:`/api/admin/delivery/config/list`


**请求方式**:`POST`


**请求数据类型**:`application/x-www-form-urlencoded,application/json`


**响应数据类型**:`*/*`


**接口描述**:


**请求示例**:


```javascript
{
  "creater": "",
  "dataType": 0,
  "defaultValue": "",
  "depart": "",
  "editable": "",
  "isAsc": "",
  "isDeleted": 0,
  "metaKey": "",
  "metaName": "",
  "metaTips": "",
  "metaValue": "",
  "orderByColumn": "",
  "pageNum": 0,
  "pageSize": 0,
  "required": "",
  "resourceId": 0,
  "sort": "",
  "updater": ""
}
```


**请求参数**:


| 参数名称                  | 参数说明            | 请求类型 | 是否必须 | 数据类型            | schema              |
| ------------------------- | ------------------- | -------- | -------- | ------------------- | ------------------- |
| resourceconfigQuery       | ResourceconfigQuery | body     | true     | ResourceconfigQuery | ResourceconfigQuery |
| &emsp;&emsp;creater       |                     |          | false    | string              |                     |
| &emsp;&emsp;dataType      |                     |          | false    | integer(int64)      |                     |
| &emsp;&emsp;defaultValue  |                     |          | false    | string              |                     |
| &emsp;&emsp;depart        |                     |          | false    | string              |                     |
| &emsp;&emsp;editable      |                     |          | false    | string              |                     |
| &emsp;&emsp;isAsc         |                     |          | false    | string              |                     |
| &emsp;&emsp;isDeleted     |                     |          | false    | integer(int32)      |                     |
| &emsp;&emsp;metaKey       |                     |          | false    | string              |                     |
| &emsp;&emsp;metaName      |                     |          | false    | string              |                     |
| &emsp;&emsp;metaTips      |                     |          | false    | string              |                     |
| &emsp;&emsp;metaValue     |                     |          | false    | string              |                     |
| &emsp;&emsp;orderByColumn |                     |          | false    | string              |                     |
| &emsp;&emsp;pageNum       |                     |          | false    | integer(int32)      |                     |
| &emsp;&emsp;pageSize      |                     |          | false    | integer(int32)      |                     |
| &emsp;&emsp;required      |                     |          | false    | string              |                     |
| &emsp;&emsp;resourceId    |                     |          | true     | integer(int64)      |                     |
| &emsp;&emsp;sort          |                     |          | false    | string              |                     |
| &emsp;&emsp;updater       |                     |          | false    | string              |                     |


**响应状态**:


| 状态码 | 说明         | schema        |
| ------ | ------------ | ------------- |
| 200    | OK           | TableDataInfo |
| 201    | Created      |               |
| 401    | Unauthorized |               |
| 403    | Forbidden    |               |
| 404    | Not Found    |               |


**响应参数**:


| 参数名称 | 参数说明 | 类型           | schema         |
| -------- | -------- | -------------- | -------------- |
| code     |          | integer(int32) | integer(int32) |
| msg      |          | string         |                |
| rows     |          | array          |                |
| total    |          | integer(int64) | integer(int64) |


**响应示例**:

```javascript
{
	"code": 0,
	"msg": "",
	"rows": [],
	"total": 0
}
```


## remove


**接口地址**:`/api/admin/delivery/config/remove`


**请求方式**:`POST`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型 | 是否必须 | 数据类型 | schema |
| -------- | -------- | -------- | -------- | -------- | ------ |
| ids      | ids      | query    | true     | string   |        |


**响应状态**:


| 状态码 | 说明         | schema    |
| ------ | ------------ | --------- |
| 200    | OK           | ResResult |
| 201    | Created      |           |
| 401    | Unauthorized |           |
| 403    | Forbidden    |           |
| 404    | Not Found    |           |


**响应参数**:


| 参数名称 | 参数说明 | 类型    | schema |
| -------- | -------- | ------- | ------ |
| code     |          | string  |        |
| msg      |          | string  |        |
| success  |          | boolean |        |
| value    |          | object  |        |


**响应示例**:

```javascript
{
	"code": "",
	"msg": "",
	"success": true,
	"value": {}
}
```


# 素材管理


## addSave


**接口地址**:`/api/admin/delivery/record/add`


**请求方式**:`POST`


**请求数据类型**:`application/x-www-form-urlencoded,application/json`


**响应数据类型**:`*/*`


**接口描述**:


**请求示例**:


```javascript
{
  "created": 0,
  "creater": "",
  "depart": "",
  "describer": "",
  "endTime": "",
  "extend": "",
  "id": 0,
  "isDeleted": 0,
  "metaJsonValue": {},
  "metaName": "",
  "metaValue": "",
  "resourceId": 0,
  "siteCode": "",
  "siteName": "",
  "sort": 0,
  "startTime": "",
  "status": "",
  "strategy": "",
  "strategyValue": "",
  "term": "",
  "termOfValidity": 0,
  "type": 0,
  "updated": 0,
  "updater": ""
}
```


**请求参数**:


| 参数名称                   | 参数说明            | 请求类型 | 是否必须 | 数据类型            | schema              |
| -------------------------- | ------------------- | -------- | -------- | ------------------- | ------------------- |
| resourceentryrecord        | Resourceentryrecord | body     | true     | Resourceentryrecord | Resourceentryrecord |
| &emsp;&emsp;created        |                     |          | false    | integer(int32)      |                     |
| &emsp;&emsp;creater        |                     |          | false    | string              |                     |
| &emsp;&emsp;depart         |                     |          | false    | string              |                     |
| &emsp;&emsp;describer      |                     |          | false    | string              |                     |
| &emsp;&emsp;endTime        |                     |          | true     | string              |                     |
| &emsp;&emsp;extend         |                     |          | false    | string              |                     |
| &emsp;&emsp;id             |                     |          | true     | integer(int64)      |                     |
| &emsp;&emsp;isDeleted      |                     |          | false    | integer(int32)      |                     |
| &emsp;&emsp;metaJsonValue  |                     |          | true     | object              |                     |
| &emsp;&emsp;metaName       |                     |          | false    | string              |                     |
| &emsp;&emsp;metaValue      |                     |          | false    | string              |                     |
| &emsp;&emsp;resourceId     |                     |          | true     | integer(int64)      |                     |
| &emsp;&emsp;siteCode       |                     |          | false    | string              |                     |
| &emsp;&emsp;siteName       |                     |          | false    | string              |                     |
| &emsp;&emsp;sort           |                     |          | false    | integer(int64)      |                     |
| &emsp;&emsp;startTime      |                     |          | true     | string              |                     |
| &emsp;&emsp;status         |                     |          | false    | string              |                     |
| &emsp;&emsp;strategy       |                     |          | false    | string              |                     |
| &emsp;&emsp;strategyValue  |                     |          | false    | string              |                     |
| &emsp;&emsp;term           |                     |          | false    | string              |                     |
| &emsp;&emsp;termOfValidity |                     |          | false    | integer(int32)      |                     |
| &emsp;&emsp;type           |                     |          | false    | integer(int32)      |                     |
| &emsp;&emsp;updated        |                     |          | false    | integer(int32)      |                     |
| &emsp;&emsp;updater        |                     |          | false    | string              |                     |


**响应状态**:


| 状态码 | 说明         | schema    |
| ------ | ------------ | --------- |
| 200    | OK           | ResResult |
| 201    | Created      |           |
| 401    | Unauthorized |           |
| 403    | Forbidden    |           |
| 404    | Not Found    |           |


**响应参数**:


| 参数名称 | 参数说明 | 类型    | schema |
| -------- | -------- | ------- | ------ |
| code     |          | string  |        |
| msg      |          | string  |        |
| success  |          | boolean |        |
| value    |          | object  |        |


**响应示例**:

```javascript
{
	"code": "",
	"msg": "",
	"success": true,
	"value": {}
}
```


## down


**接口地址**:`/api/admin/delivery/record/down`


**请求方式**:`POST`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型 | 是否必须 | 数据类型 | schema |
| -------- | -------- | -------- | -------- | -------- | ------ |
| ids      | ids      | query    | true     | string   |        |


**响应状态**:


| 状态码 | 说明         | schema    |
| ------ | ------------ | --------- |
| 200    | OK           | ResResult |
| 201    | Created      |           |
| 401    | Unauthorized |           |
| 403    | Forbidden    |           |
| 404    | Not Found    |           |


**响应参数**:


| 参数名称 | 参数说明 | 类型    | schema |
| -------- | -------- | ------- | ------ |
| code     |          | string  |        |
| msg      |          | string  |        |
| success  |          | boolean |        |
| value    |          | object  |        |


**响应示例**:

```javascript
{
	"code": "",
	"msg": "",
	"success": true,
	"value": {}
}
```


## editSave


**接口地址**:`/api/admin/delivery/record/edit`


**请求方式**:`POST`


**请求数据类型**:`application/x-www-form-urlencoded,application/json`


**响应数据类型**:`*/*`


**接口描述**:


**请求示例**:


```javascript
{
  "created": 0,
  "creater": "",
  "depart": "",
  "describer": "",
  "endTime": "",
  "extend": "",
  "id": 0,
  "isDeleted": 0,
  "metaJsonValue": {},
  "metaName": "",
  "metaValue": "",
  "resourceId": 0,
  "siteCode": "",
  "siteName": "",
  "sort": 0,
  "startTime": "",
  "status": "",
  "strategy": "",
  "strategyValue": "",
  "term": "",
  "termOfValidity": 0,
  "type": 0,
  "updated": 0,
  "updater": ""
}
```


**请求参数**:


| 参数名称                   | 参数说明            | 请求类型 | 是否必须 | 数据类型            | schema              |
| -------------------------- | ------------------- | -------- | -------- | ------------------- | ------------------- |
| resourceentryrecord        | Resourceentryrecord | body     | true     | Resourceentryrecord | Resourceentryrecord |
| &emsp;&emsp;created        |                     |          | false    | integer(int32)      |                     |
| &emsp;&emsp;creater        |                     |          | false    | string              |                     |
| &emsp;&emsp;depart         |                     |          | false    | string              |                     |
| &emsp;&emsp;describer      |                     |          | false    | string              |                     |
| &emsp;&emsp;endTime        |                     |          | true     | string              |                     |
| &emsp;&emsp;extend         |                     |          | false    | string              |                     |
| &emsp;&emsp;id             |                     |          | true     | integer(int64)      |                     |
| &emsp;&emsp;isDeleted      |                     |          | false    | integer(int32)      |                     |
| &emsp;&emsp;metaJsonValue  |                     |          | true     | object              |                     |
| &emsp;&emsp;metaName       |                     |          | false    | string              |                     |
| &emsp;&emsp;metaValue      |                     |          | false    | string              |                     |
| &emsp;&emsp;resourceId     |                     |          | true     | integer(int64)      |                     |
| &emsp;&emsp;siteCode       |                     |          | false    | string              |                     |
| &emsp;&emsp;siteName       |                     |          | false    | string              |                     |
| &emsp;&emsp;sort           |                     |          | false    | integer(int64)      |                     |
| &emsp;&emsp;startTime      |                     |          | true     | string              |                     |
| &emsp;&emsp;status         |                     |          | false    | string              |                     |
| &emsp;&emsp;strategy       |                     |          | false    | string              |                     |
| &emsp;&emsp;strategyValue  |                     |          | false    | string              |                     |
| &emsp;&emsp;term           |                     |          | false    | string              |                     |
| &emsp;&emsp;termOfValidity |                     |          | false    | integer(int32)      |                     |
| &emsp;&emsp;type           |                     |          | false    | integer(int32)      |                     |
| &emsp;&emsp;updated        |                     |          | false    | integer(int32)      |                     |
| &emsp;&emsp;updater        |                     |          | false    | string              |                     |


**响应状态**:


| 状态码 | 说明         | schema    |
| ------ | ------------ | --------- |
| 200    | OK           | ResResult |
| 201    | Created      |           |
| 401    | Unauthorized |           |
| 403    | Forbidden    |           |
| 404    | Not Found    |           |


**响应参数**:


| 参数名称 | 参数说明 | 类型    | schema |
| -------- | -------- | ------- | ------ |
| code     |          | string  |        |
| msg      |          | string  |        |
| success  |          | boolean |        |
| value    |          | object  |        |


**响应示例**:

```javascript
{
	"code": "",
	"msg": "",
	"success": true,
	"value": {}
}
```


## list


**接口地址**:`/api/admin/delivery/record/list`


**请求方式**:`POST`


**请求数据类型**:`application/x-www-form-urlencoded,application/json`


**响应数据类型**:`*/*`


**接口描述**:


**请求示例**:


```javascript
{
  "creater": "",
  "depart": "",
  "describer": "",
  "endTime": "",
  "extend": "",
  "isAsc": "",
  "isDeleted": 0,
  "metaName": "",
  "metaValue": "",
  "orderByColumn": "",
  "pageNum": 0,
  "pageSize": 0,
  "resourceId": 0,
  "siteCode": "",
  "siteName": "",
  "sort": 0,
  "startTime": "",
  "status": "",
  "strategy": "",
  "strategyValue": "",
  "term": "",
  "termOfValidity": 0,
  "type": 0,
  "updater": ""
}
```


**请求参数**:


| 参数名称                   | 参数说明                 | 请求类型 | 是否必须 | 数据类型                 | schema                   |
| -------------------------- | ------------------------ | -------- | -------- | ------------------------ | ------------------------ |
| resourceentryrecordQuery   | ResourceentryrecordQuery | body     | true     | ResourceentryrecordQuery | ResourceentryrecordQuery |
| &emsp;&emsp;creater        |                          |          | false    | string                   |                          |
| &emsp;&emsp;depart         |                          |          | false    | string                   |                          |
| &emsp;&emsp;describer      |                          |          | false    | string                   |                          |
| &emsp;&emsp;endTime        |                          |          | false    | string                   |                          |
| &emsp;&emsp;extend         |                          |          | false    | string                   |                          |
| &emsp;&emsp;isAsc          |                          |          | false    | string                   |                          |
| &emsp;&emsp;isDeleted      |                          |          | false    | integer(int32)           |                          |
| &emsp;&emsp;metaName       |                          |          | false    | string                   |                          |
| &emsp;&emsp;metaValue      |                          |          | false    | string                   |                          |
| &emsp;&emsp;orderByColumn  |                          |          | false    | string                   |                          |
| &emsp;&emsp;pageNum        |                          |          | false    | integer(int32)           |                          |
| &emsp;&emsp;pageSize       |                          |          | false    | integer(int32)           |                          |
| &emsp;&emsp;resourceId     |                          |          | true     | integer(int64)           |                          |
| &emsp;&emsp;siteCode       |                          |          | false    | string                   |                          |
| &emsp;&emsp;siteName       |                          |          | false    | string                   |                          |
| &emsp;&emsp;sort           |                          |          | false    | integer(int64)           |                          |
| &emsp;&emsp;startTime      |                          |          | false    | string                   |                          |
| &emsp;&emsp;status         |                          |          | false    | string                   |                          |
| &emsp;&emsp;strategy       |                          |          | false    | string                   |                          |
| &emsp;&emsp;strategyValue  |                          |          | false    | string                   |                          |
| &emsp;&emsp;term           |                          |          | false    | string                   |                          |
| &emsp;&emsp;termOfValidity |                          |          | false    | integer(int32)           |                          |
| &emsp;&emsp;type           |                          |          | false    | integer(int32)           |                          |
| &emsp;&emsp;updater        |                          |          | false    | string                   |                          |


**响应状态**:


| 状态码 | 说明         | schema    |
| ------ | ------------ | --------- |
| 200    | OK           | ResResult |
| 201    | Created      |           |
| 401    | Unauthorized |           |
| 403    | Forbidden    |           |
| 404    | Not Found    |           |


**响应参数**:


| 参数名称 | 参数说明 | 类型    | schema |
| -------- | -------- | ------- | ------ |
| code     |          | string  |        |
| msg      |          | string  |        |
| success  |          | boolean |        |
| value    |          | object  |        |


**响应示例**:

```javascript
{
	"code": "",
	"msg": "",
	"success": true,
	"value": {}
}
```


## remove


**接口地址**:`/api/admin/delivery/record/remove`


**请求方式**:`POST`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型 | 是否必须 | 数据类型 | schema |
| -------- | -------- | -------- | -------- | -------- | ------ |
| ids      | ids      | query    | true     | string   |        |


**响应状态**:


| 状态码 | 说明         | schema    |
| ------ | ------------ | --------- |
| 200    | OK           | ResResult |
| 201    | Created      |           |
| 401    | Unauthorized |           |
| 403    | Forbidden    |           |
| 404    | Not Found    |           |


**响应参数**:


| 参数名称 | 参数说明 | 类型    | schema |
| -------- | -------- | ------- | ------ |
| code     |          | string  |        |
| msg      |          | string  |        |
| success  |          | boolean |        |
| value    |          | object  |        |


**响应示例**:

```javascript
{
	"code": "",
	"msg": "",
	"success": true,
	"value": {}
}
```


## up


**接口地址**:`/api/admin/delivery/record/up`


**请求方式**:`POST`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型 | 是否必须 | 数据类型 | schema |
| -------- | -------- | -------- | -------- | -------- | ------ |
| ids      | ids      | query    | true     | string   |        |


**响应状态**:


| 状态码 | 说明         | schema    |
| ------ | ------------ | --------- |
| 200    | OK           | ResResult |
| 201    | Created      |           |
| 401    | Unauthorized |           |
| 403    | Forbidden    |           |
| 404    | Not Found    |           |


**响应参数**:


| 参数名称 | 参数说明 | 类型    | schema |
| -------- | -------- | ------- | ------ |
| code     |          | string  |        |
| msg      |          | string  |        |
| success  |          | boolean |        |
| value    |          | object  |        |


**响应示例**:

```javascript
{
	"code": "",
	"msg": "",
	"success": true,
	"value": {}
}
```


