define({ "api": [
  {
    "type": "POST",
    "url": "/course/addCourse",
    "title": "addCourse",
    "version": "1.0.0",
    "group": "CourseController",
    "name": "addCourse",
    "description": "<p>添加一个课程</p>",
    "parameter": {
      "fields": {
        "请求参数": [
          {
            "group": "请求参数",
            "type": "String",
            "optional": false,
            "field": "course",
            "description": "<p>course是一个由course对象转化的json字符串</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "Request-Example:",
          "content": "先封装好一个course对象\nvar course = {\n\"openid\": \"oNTNQ5EVBLG1qFO2QfNGEm6hcdrk\",\n\"courseName\": \"java\",    课程名称 String\n\"classroom\": \"四区205\",   教室 String\n\"weeks\": [1,3,5,9, 12, 13, 14, 15, 16, 18],  上课周次 int数组\n\"day\": 3, 周几上课 int\n\"jieshu\": 4,  上课节数 上午8:00-10:00为第一节 一天五节课以此类推\n\"teacher\": \"陈景涛\"  任课老师\n}\n请求的时候应该是这样:\n{\n\"course\": JSON.stringify(course)\n}",
          "type": "json"
        }
      ]
    },
    "success": {
      "fields": {
        "响应结果": [
          {
            "group": "响应结果",
            "type": "Number",
            "optional": false,
            "field": "code",
            "description": ""
          },
          {
            "group": "响应结果",
            "type": "String",
            "optional": false,
            "field": "msg",
            "description": ""
          },
          {
            "group": "响应结果",
            "type": "Object",
            "optional": false,
            "field": "data",
            "description": ""
          }
        ]
      },
      "examples": [
        {
          "title": "响应结果示例",
          "content": "{\"msg\":\"U\",\"code\":4919,\"data\":{}}",
          "type": "json"
        }
      ]
    },
    "filename": "src/main/java/com/example/jingtao/contrller/CourseController.java",
    "groupTitle": "CourseController"
  },
  {
    "type": "POST",
    "url": "/course/deleteACourse",
    "title": "deleteACourse",
    "version": "1.0.0",
    "group": "CourseController",
    "name": "deleteACourse",
    "description": "<p>删除一节课 因为课程表没有主键 所以删除的时候必须保证每个字段都要相等</p>",
    "parameter": {
      "fields": {
        "请求参数": [
          {
            "group": "请求参数",
            "type": "String",
            "optional": false,
            "field": "course",
            "description": "<p>course对象的json字符串</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "请求参数示例",
          "content": "先封装好一个course对象\nvar course = {\n\"openid\": \"oNTNQ5EVBLG1qFO2QfNGEm6hcdrk\",\n\"courseName\": \"java\",    课程名称 String\n\"classroom\": \"四区205\",   教室 String\n\"weeks\": [1,3,5,9, 12, 13, 14, 15, 16, 18],  上课周次 int数组\n\"day\": 3, 周几上课 int\n\"jieshu\": 4,  上课节数 上午8:00-10:00为第一节 一天五节课以此类推\n\"teacher\": \"陈景涛\"  任课老师\n}\n请求的时候应该是这样:\n{\n\"course\": JSON.stringify(course)\n}",
          "type": "json"
        }
      ]
    },
    "success": {
      "fields": {
        "响应结果": [
          {
            "group": "响应结果",
            "type": "Number",
            "optional": false,
            "field": "code",
            "description": ""
          },
          {
            "group": "响应结果",
            "type": "String",
            "optional": false,
            "field": "msg",
            "description": ""
          },
          {
            "group": "响应结果",
            "type": "Object",
            "optional": false,
            "field": "data",
            "description": ""
          }
        ]
      },
      "examples": [
        {
          "title": "响应结果示例",
          "content": "{\"msg\":\"p0xc2AIN\",\"code\":8678,\"data\":{}}",
          "type": "json"
        }
      ]
    },
    "filename": "src/main/java/com/example/jingtao/contrller/CourseController.java",
    "groupTitle": "CourseController"
  },
  {
    "type": "POST",
    "url": "/course/deleteAllCourseByOpenid",
    "title": "deleteAllCourseByOpenid",
    "version": "1.0.0",
    "group": "CourseController",
    "name": "deleteAllCourseByOpenid",
    "description": "<p>清空课表 如果用户改变用户信息应该调用这个接口清空原有课表</p>",
    "parameter": {
      "fields": {
        "请求参数": [
          {
            "group": "请求参数",
            "type": "String",
            "optional": false,
            "field": "openid",
            "description": "<p>openid唯一标识</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "请求参数示例",
          "content": "openid=O",
          "type": "json"
        }
      ]
    },
    "success": {
      "fields": {
        "响应结果": [
          {
            "group": "响应结果",
            "type": "Number",
            "optional": false,
            "field": "code",
            "description": ""
          },
          {
            "group": "响应结果",
            "type": "String",
            "optional": false,
            "field": "msg",
            "description": ""
          },
          {
            "group": "响应结果",
            "type": "Object",
            "optional": false,
            "field": "data",
            "description": ""
          }
        ]
      },
      "examples": [
        {
          "title": "响应结果示例",
          "content": "{\"msg\":\"o\",\"code\":119,\"data\":{}}",
          "type": "json"
        }
      ]
    },
    "filename": "src/main/java/com/example/jingtao/contrller/CourseController.java",
    "groupTitle": "CourseController"
  },
  {
    "type": "POST",
    "url": "/course/importCourse",
    "title": "importCourse",
    "version": "5.0.0",
    "group": "CourseController",
    "name": "importCourse",
    "description": "<p>自动导入本学期课表 目前仅支持山东大学 请期待后续更新</p>",
    "parameter": {
      "fields": {
        "请求参数": [
          {
            "group": "请求参数",
            "type": "String",
            "optional": false,
            "field": "openid",
            "description": ""
          },
          {
            "group": "请求参数",
            "type": "String",
            "optional": false,
            "field": "username",
            "description": "<p>学生账号</p>"
          },
          {
            "group": "请求参数",
            "type": "String",
            "optional": false,
            "field": "password",
            "description": "<p>密码</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "请求参数示例",
          "content": "password=cHf9Xb&openid=Q7hxK6n4U&username=gRF",
          "type": "json"
        }
      ]
    },
    "success": {
      "fields": {
        "响应结果": [
          {
            "group": "响应结果",
            "type": "Number",
            "optional": false,
            "field": "code",
            "description": ""
          },
          {
            "group": "响应结果",
            "type": "String",
            "optional": false,
            "field": "msg",
            "description": ""
          },
          {
            "group": "响应结果",
            "type": "Object",
            "optional": false,
            "field": "data",
            "description": "<p>没有返回值</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "响应结果示例",
          "content": "{\"msg\":\"FzxEUmBB\",\"code\":4080,\"data\":{}}",
          "type": "json"
        }
      ]
    },
    "filename": "src/main/java/com/example/jingtao/contrller/CourseController.java",
    "groupTitle": "CourseController"
  },
  {
    "type": "POST",
    "url": "/course/selectByOpenidAndWeeks",
    "title": "selectByOpenidAndWeeks",
    "version": "1.0.0",
    "group": "CourseController",
    "name": "selectByOpenidAndWeeks",
    "description": "<p>根据openid和周次来获取本周的课表</p>",
    "parameter": {
      "fields": {
        "请求参数": [
          {
            "group": "请求参数",
            "type": "String",
            "optional": false,
            "field": "openid",
            "description": ""
          },
          {
            "group": "请求参数",
            "type": "String",
            "optional": false,
            "field": "week",
            "description": "<p>第几周</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "请求参数示例",
          "content": "week=VZ&openid=L",
          "type": "json"
        }
      ]
    },
    "success": {
      "fields": {
        "响应结果": [
          {
            "group": "响应结果",
            "type": "Number",
            "optional": false,
            "field": "code",
            "description": ""
          },
          {
            "group": "响应结果",
            "type": "String",
            "optional": false,
            "field": "msg",
            "description": ""
          },
          {
            "group": "响应结果",
            "type": "Object",
            "optional": false,
            "field": "data",
            "description": ""
          }
        ]
      },
      "examples": [
        {
          "title": "响应结果示例",
          "content": "{\"msg\":\"OdaH\",\"code\":8126,\"data\":{}}",
          "type": "json"
        }
      ]
    },
    "filename": "src/main/java/com/example/jingtao/contrller/CourseController.java",
    "groupTitle": "CourseController"
  },
  {
    "type": "POST",
    "url": "/login",
    "title": "login",
    "version": "1.0.0",
    "group": "LoginController",
    "name": "login",
    "description": "<p>这个接口用来登录 返回用户的openid token 保存</p>",
    "parameter": {
      "fields": {
        "请求参数": [
          {
            "group": "请求参数",
            "type": "String",
            "optional": false,
            "field": "code",
            "description": "<p>你调用完wx.login把这个code发给我</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "请求参数示例",
          "content": "code=OgLU",
          "type": "json"
        }
      ]
    },
    "success": {
      "fields": {
        "响应结果": [
          {
            "group": "响应结果",
            "type": "Number",
            "optional": false,
            "field": "code",
            "description": "<p>1为成功 -1为失败 0为需要登录</p>"
          },
          {
            "group": "响应结果",
            "type": "String",
            "optional": false,
            "field": "msg",
            "description": "<p>给你的提示信息</p>"
          },
          {
            "group": "响应结果",
            "type": "Object",
            "optional": false,
            "field": "data",
            "description": "<p>返回的数据都封装在这个对象里</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "响应结果示例",
          "content": "{\"msg\":\"6SdzECs\",\"code\":9757,\"data\":{}}",
          "type": "json"
        }
      ]
    },
    "filename": "src/main/java/com/example/jingtao/contrller/LoginController.java",
    "groupTitle": "LoginController"
  },
  {
    "type": "GET",
    "url": "/note/getNotes",
    "title": "getNotes",
    "version": "2.0.0",
    "group": "NoteController",
    "name": "getNotes",
    "description": "<p>返回该openid的所有纸条记录</p>",
    "parameter": {
      "fields": {
        "请求参数": [
          {
            "group": "请求参数",
            "type": "String",
            "optional": false,
            "field": "openid",
            "description": "<p>这个用户的openid</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "请求参数示例",
          "content": "openid=Mxu06m2N",
          "type": "json"
        }
      ]
    },
    "success": {
      "fields": {
        "响应结果": [
          {
            "group": "响应结果",
            "type": "Number",
            "optional": false,
            "field": "code",
            "description": ""
          },
          {
            "group": "响应结果",
            "type": "String",
            "optional": false,
            "field": "msg",
            "description": "<p>这是给前端的提示</p>"
          },
          {
            "group": "响应结果",
            "type": "Object",
            "optional": false,
            "field": "data",
            "description": "<p>这里面放的是一个map map为key 纸条对方 value 本用户与key用户的纸条记录list集合</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "响应结果示例",
          "content": "查询jingtao的纸条记录 返回的map中分别是 xinyi，asvcvyewvyv，wasd 和jingtao的纸条记录\n纸条记录是一个封装好的对象\nsender是发送者openid\naccepter是接受者openid\nmessage 内容\ntime 发送时间 在数据库是datatime对象 你可以根据这个来排序\nlook 发送时默认为0 当接收方看到消息时 该值修改为1 代表对方已读\n{\n    \"code\": 1,\n    \"msg\": \"ok\",\n    \"data\": {\n        \"xinyi\": [\n            {\n                \"sender\": \"xinyi\",\n                \"accepter\": \"jingtao\",\n                \"message\": \"vsdvhbiewvebajosvh\",\n                \"time\": \"2021-05-15T14:03:19.000+00:00\",\n                \"look\": 0\n            },\n            {\n                \"sender\": \"jingtao\",\n                \"accepter\": \"xinyi\",\n                \"message\": \"hello\",\n                \"time\": \"2021-05-15T05:12:44.000+00:00\",\n                \"look\": 0\n            },\n            {\n                \"sender\": \"jingtao\",\n                \"accepter\": \"xinyi\",\n                \"message\": \"wasd\",\n                \"time\": \"2021-05-15T05:49:36.000+00:00\",\n                \"look\": 0\n            }\n        ],\n        \"asvcvyewvyv\": [\n            {\n                \"sender\": \"asvcvyewvyv\",\n                \"accepter\": \"jingtao\",\n                \"message\": \"wevgvwibciq\",\n                \"time\": \"2021-05-15T05:49:36.000+00:00\",\n                \"look\": 0\n            }\n        ],\n        \"wasd\": [\n            {\n                \"sender\": \"jingtao\",\n                \"accepter\": \"wasd\",\n                \"message\": \"wasd\",\n                \"time\": \"2021-05-15T05:58:01.000+00:00\",\n                \"look\": 0\n            }\n        ]\n    }\n}",
          "type": "json"
        }
      ]
    },
    "filename": "src/main/java/com/example/jingtao/contrller/NoteController.java",
    "groupTitle": "NoteController"
  },
  {
    "type": "POST",
    "url": "/note/sendMsg",
    "title": "sendMsg",
    "version": "2.0.0",
    "group": "NoteController",
    "name": "sendMsg",
    "description": "<p>这个接口用来发送消息</p>",
    "parameter": {
      "fields": {
        "请求参数": [
          {
            "group": "请求参数",
            "type": "String",
            "optional": false,
            "field": "sender",
            "description": "<p>发送者的openid</p>"
          },
          {
            "group": "请求参数",
            "type": "String",
            "optional": false,
            "field": "accepter",
            "description": "<p>接受者的openid</p>"
          },
          {
            "group": "请求参数",
            "type": "String",
            "optional": false,
            "field": "msg",
            "description": "<p>这是要发送的文字</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "请求参数示例",
          "content": "msg=nriWTF1qxM&sender=ss8M1&accepter=9WBADw",
          "type": "json"
        }
      ]
    },
    "success": {
      "fields": {
        "响应结果": [
          {
            "group": "响应结果",
            "type": "Number",
            "optional": false,
            "field": "code",
            "description": ""
          },
          {
            "group": "响应结果",
            "type": "String",
            "optional": false,
            "field": "msg",
            "description": ""
          },
          {
            "group": "响应结果",
            "type": "Object",
            "optional": false,
            "field": "data",
            "description": "<p>没有返回数据 返回null</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "响应结果示例",
          "content": "{\"msg\":\"7tvtivC\",\"code\":1252,\"data\":{}}",
          "type": "json"
        }
      ]
    },
    "filename": "src/main/java/com/example/jingtao/contrller/NoteController.java",
    "groupTitle": "NoteController"
  },
  {
    "type": "GET",
    "url": "/OnInputQuery/queryCollege",
    "title": "queryCollege",
    "version": "1.0.0",
    "group": "OnInputQueryController",
    "name": "queryCollege",
    "description": "<p>查询学院</p>",
    "parameter": {
      "fields": {
        "请求参数": [
          {
            "group": "请求参数",
            "type": "String",
            "optional": false,
            "field": "school",
            "description": "<p>在查询学院时学校应该是完整的</p>"
          },
          {
            "group": "请求参数",
            "type": "String",
            "optional": false,
            "field": "college",
            "description": ""
          }
        ]
      },
      "examples": [
        {
          "title": "请求参数示例",
          "content": "college=OupVjDl&school=rRUX",
          "type": "json"
        }
      ]
    },
    "success": {
      "fields": {
        "响应结果": [
          {
            "group": "响应结果",
            "type": "Number",
            "optional": false,
            "field": "code",
            "description": ""
          },
          {
            "group": "响应结果",
            "type": "String",
            "optional": false,
            "field": "msg",
            "description": ""
          },
          {
            "group": "响应结果",
            "type": "Object",
            "optional": false,
            "field": "data",
            "description": ""
          }
        ]
      },
      "examples": [
        {
          "title": "响应结果示例",
          "content": "{\"msg\":\"0C6cziYQf9\",\"code\":8622,\"data\":{}}",
          "type": "json"
        }
      ]
    },
    "filename": "src/main/java/com/example/jingtao/contrller/OnInputQueryController.java",
    "groupTitle": "OnInputQueryController"
  },
  {
    "type": "GET",
    "url": "/OnInputQuery/queryMajor",
    "title": "queryMajor",
    "version": "1.0.0",
    "group": "OnInputQueryController",
    "name": "queryMajor",
    "description": "<p>查询专业</p>",
    "parameter": {
      "fields": {
        "请求参数": [
          {
            "group": "请求参数",
            "type": "String",
            "optional": false,
            "field": "school",
            "description": "<p>应该完整</p>"
          },
          {
            "group": "请求参数",
            "type": "String",
            "optional": false,
            "field": "college",
            "description": "<p>应该完整</p>"
          },
          {
            "group": "请求参数",
            "type": "String",
            "optional": false,
            "field": "major",
            "description": ""
          }
        ]
      },
      "examples": [
        {
          "title": "请求参数示例",
          "content": "college=fhEcVmh&major=YakPzVhM&school=SyA2wvc",
          "type": "json"
        }
      ]
    },
    "success": {
      "fields": {
        "响应结果": [
          {
            "group": "响应结果",
            "type": "Number",
            "optional": false,
            "field": "code",
            "description": ""
          },
          {
            "group": "响应结果",
            "type": "String",
            "optional": false,
            "field": "msg",
            "description": ""
          },
          {
            "group": "响应结果",
            "type": "Object",
            "optional": false,
            "field": "data",
            "description": ""
          }
        ]
      },
      "examples": [
        {
          "title": "响应结果示例",
          "content": "{\"msg\":\"Y9utsoAeGn\",\"code\":5481,\"data\":{}}",
          "type": "json"
        }
      ]
    },
    "filename": "src/main/java/com/example/jingtao/contrller/OnInputQueryController.java",
    "groupTitle": "OnInputQueryController"
  },
  {
    "type": "GET",
    "url": "/OnInputQuery/querySchool",
    "title": "querySchool",
    "version": "1.0.0",
    "group": "OnInputQueryController",
    "name": "querySchool",
    "description": "<p>查询学校</p>",
    "parameter": {
      "fields": {
        "请求参数": [
          {
            "group": "请求参数",
            "type": "String",
            "optional": false,
            "field": "school",
            "description": ""
          }
        ]
      },
      "examples": [
        {
          "title": "请求参数示例",
          "content": "school=OGLtUpepYh",
          "type": "json"
        }
      ]
    },
    "success": {
      "fields": {
        "响应结果": [
          {
            "group": "响应结果",
            "type": "Number",
            "optional": false,
            "field": "code",
            "description": ""
          },
          {
            "group": "响应结果",
            "type": "String",
            "optional": false,
            "field": "msg",
            "description": ""
          },
          {
            "group": "响应结果",
            "type": "Object",
            "optional": false,
            "field": "data",
            "description": ""
          }
        ]
      },
      "examples": [
        {
          "title": "响应结果示例",
          "content": "{\"msg\":\"6Tao\",\"code\":3641,\"data\":{}}",
          "type": "json"
        }
      ]
    },
    "filename": "src/main/java/com/example/jingtao/contrller/OnInputQueryController.java",
    "groupTitle": "OnInputQueryController"
  },
  {
    "type": "POST",
    "url": "/post/addAPost",
    "title": "addAPost",
    "version": "4.0.0",
    "group": "PostController",
    "name": "addAPost",
    "description": "<p>发布一个新帖子</p>",
    "parameter": {
      "fields": {
        "请求参数": [
          {
            "group": "请求参数",
            "type": "String",
            "optional": false,
            "field": "openid",
            "description": ""
          },
          {
            "group": "请求参数",
            "type": "String",
            "optional": false,
            "field": "school",
            "description": "<p>学校</p>"
          },
          {
            "group": "请求参数",
            "type": "String",
            "optional": false,
            "field": "content",
            "description": "<p>内容</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "请求参数示例",
          "content": "school=mlz&openid=jSRbxj&content=LEJDsqppd",
          "type": "json"
        }
      ]
    },
    "success": {
      "fields": {
        "响应结果": [
          {
            "group": "响应结果",
            "type": "Number",
            "optional": false,
            "field": "code",
            "description": ""
          },
          {
            "group": "响应结果",
            "type": "String",
            "optional": false,
            "field": "msg",
            "description": ""
          },
          {
            "group": "响应结果",
            "type": "Object",
            "optional": false,
            "field": "data",
            "description": "<p>data里会有一个字符串postId 你在回调方法里用这个上传图片</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "响应结果示例",
          "content": "{\"msg\":\"oj3\",\"code\":5116,\"data\":{}}",
          "type": "json"
        }
      ]
    },
    "filename": "src/main/java/com/example/jingtao/contrller/PostController.java",
    "groupTitle": "PostController"
  },
  {
    "type": "POST",
    "url": "/post/addAPostImage",
    "title": "addAPostImage",
    "version": "4.0.0",
    "group": "PostController",
    "name": "addAPostImage",
    "description": "<p>一次只能上传一张图片，你在前端循环调用upload方法，每张图片要指定一个顺序，从零开始</p>",
    "parameter": {
      "fields": {
        "请求参数": [
          {
            "group": "请求参数",
            "type": "Object",
            "optional": false,
            "field": "file",
            "description": "<p>你的图片文件</p>"
          },
          {
            "group": "请求参数",
            "type": "String",
            "optional": false,
            "field": "postId",
            "description": "<p>发给你的postId</p>"
          },
          {
            "group": "请求参数",
            "type": "Number",
            "optional": false,
            "field": "imageId",
            "description": "<p>图片的顺序0.1.2.3这样</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "请求参数示例",
          "content": "file=null&imageId=1021&postId=p",
          "type": "json"
        }
      ]
    },
    "success": {
      "fields": {
        "响应结果": [
          {
            "group": "响应结果",
            "type": "Number",
            "optional": false,
            "field": "code",
            "description": ""
          },
          {
            "group": "响应结果",
            "type": "String",
            "optional": false,
            "field": "msg",
            "description": ""
          },
          {
            "group": "响应结果",
            "type": "Object",
            "optional": false,
            "field": "data",
            "description": ""
          }
        ]
      },
      "examples": [
        {
          "title": "响应结果示例",
          "content": "{\"msg\":\"N\",\"code\":6209,\"data\":{}}",
          "type": "json"
        }
      ]
    },
    "filename": "src/main/java/com/example/jingtao/contrller/PostController.java",
    "groupTitle": "PostController"
  },
  {
    "type": "GET",
    "url": "/post/deleteAPostByPostId",
    "title": "deleteAPostByPostId",
    "version": "4.0.0",
    "group": "PostController",
    "name": "deleteAPostByPostId",
    "description": "<p>通过postId来删除一条post记录</p>",
    "parameter": {
      "fields": {
        "请求参数": [
          {
            "group": "请求参数",
            "type": "String",
            "optional": false,
            "field": "postId",
            "description": ""
          }
        ]
      },
      "examples": [
        {
          "title": "请求参数示例",
          "content": "postId=oV6kn67sy",
          "type": "json"
        }
      ]
    },
    "success": {
      "fields": {
        "响应结果": [
          {
            "group": "响应结果",
            "type": "Number",
            "optional": false,
            "field": "code",
            "description": ""
          },
          {
            "group": "响应结果",
            "type": "String",
            "optional": false,
            "field": "msg",
            "description": ""
          },
          {
            "group": "响应结果",
            "type": "Object",
            "optional": false,
            "field": "data",
            "description": ""
          }
        ]
      },
      "examples": [
        {
          "title": "响应结果示例",
          "content": "{\"msg\":\"bzpCRYvZk\",\"code\":6406,\"data\":{}}",
          "type": "json"
        }
      ]
    },
    "filename": "src/main/java/com/example/jingtao/contrller/PostController.java",
    "groupTitle": "PostController"
  },
  {
    "type": "GET",
    "url": "/post/getAllPost",
    "title": "getAllPost",
    "version": "4.0.0",
    "group": "PostController",
    "name": "getAllPost",
    "description": "<p>获取所有用户的所有帖子</p>",
    "success": {
      "fields": {
        "响应结果": [
          {
            "group": "响应结果",
            "type": "Array",
            "optional": false,
            "field": "response",
            "description": ""
          },
          {
            "group": "响应结果",
            "type": "String",
            "optional": false,
            "field": "response.postId",
            "description": ""
          },
          {
            "group": "响应结果",
            "type": "String",
            "optional": false,
            "field": "response.openid",
            "description": ""
          },
          {
            "group": "响应结果",
            "type": "String",
            "optional": false,
            "field": "response.school",
            "description": ""
          },
          {
            "group": "响应结果",
            "type": "String",
            "optional": false,
            "field": "response.content",
            "description": ""
          },
          {
            "group": "响应结果",
            "type": "Number",
            "optional": false,
            "field": "response.time",
            "description": ""
          },
          {
            "group": "响应结果",
            "type": "Array",
            "optional": false,
            "field": "response.arraylist",
            "description": ""
          }
        ]
      },
      "examples": [
        {
          "title": "响应结果示例",
          "content": "[{\"school\":\"xb4xcBI\",\"openid\":\"LSuUuVgKEz\",\"postId\":\"bFjU\",\"time\":3072972334286,\"arraylist\":[\"NJVL7NG\"],\"content\":\"XeXX5VuN1\"}]",
          "type": "json"
        }
      ]
    },
    "filename": "src/main/java/com/example/jingtao/contrller/PostController.java",
    "groupTitle": "PostController"
  },
  {
    "type": "GET",
    "url": "/post/getAllPostLimit",
    "title": "getAllPostLimit",
    "version": "4.0.0",
    "group": "PostController",
    "name": "getAllPostLimit",
    "description": "<p>获取所有用户的指定数目的帖子</p>",
    "parameter": {
      "fields": {
        "请求参数": [
          {
            "group": "请求参数",
            "type": "Number",
            "optional": false,
            "field": "num",
            "description": ""
          }
        ]
      },
      "examples": [
        {
          "title": "请求参数示例",
          "content": "num=9650",
          "type": "json"
        }
      ]
    },
    "success": {
      "fields": {
        "响应结果": [
          {
            "group": "响应结果",
            "type": "Array",
            "optional": false,
            "field": "response",
            "description": ""
          },
          {
            "group": "响应结果",
            "type": "String",
            "optional": false,
            "field": "response.postId",
            "description": ""
          },
          {
            "group": "响应结果",
            "type": "String",
            "optional": false,
            "field": "response.openid",
            "description": ""
          },
          {
            "group": "响应结果",
            "type": "String",
            "optional": false,
            "field": "response.school",
            "description": ""
          },
          {
            "group": "响应结果",
            "type": "String",
            "optional": false,
            "field": "response.content",
            "description": ""
          },
          {
            "group": "响应结果",
            "type": "Number",
            "optional": false,
            "field": "response.time",
            "description": ""
          },
          {
            "group": "响应结果",
            "type": "Array",
            "optional": false,
            "field": "response.arraylist",
            "description": ""
          }
        ]
      },
      "examples": [
        {
          "title": "响应结果示例",
          "content": "[{\"school\":\"fwQLE7ODeE\",\"openid\":\"yDG\",\"postId\":\"4LGw5qYT\",\"time\":1425295824718,\"arraylist\":[\"feP8redS\"],\"content\":\"5X\"}]",
          "type": "json"
        }
      ]
    },
    "filename": "src/main/java/com/example/jingtao/contrller/PostController.java",
    "groupTitle": "PostController"
  },
  {
    "type": "POST",
    "url": "/post/getImg",
    "title": "getImg",
    "version": "4.0.0",
    "group": "PostController",
    "name": "getImg",
    "description": "<p>获取帖子的图片资源  已经在返回数据的数组里封装好了 直接等于src就可</p>",
    "parameter": {
      "fields": {
        "请求参数": [
          {
            "group": "请求参数",
            "type": "String",
            "optional": false,
            "field": "postId",
            "description": ""
          },
          {
            "group": "请求参数",
            "type": "Number",
            "optional": false,
            "field": "imageId",
            "description": ""
          }
        ]
      },
      "examples": [
        {
          "title": "请求参数示例",
          "content": "imageId=8309&postId=ku",
          "type": "json"
        }
      ]
    },
    "success": {
      "fields": {
        "响应结果": [
          {
            "group": "响应结果",
            "type": "Object",
            "optional": false,
            "field": "response",
            "description": ""
          }
        ]
      },
      "examples": [
        {
          "title": "响应结果示例",
          "content": "null",
          "type": "json"
        }
      ]
    },
    "filename": "src/main/java/com/example/jingtao/contrller/PostController.java",
    "groupTitle": "PostController"
  },
  {
    "type": "GET",
    "url": "/post/getPostByOpenid",
    "title": "getPostByOpenid",
    "version": "4.0.0",
    "group": "PostController",
    "name": "getPostByOpenid",
    "description": "<p>通过openid来获取该用户发布的全部帖子</p>",
    "parameter": {
      "fields": {
        "请求参数": [
          {
            "group": "请求参数",
            "type": "String",
            "optional": false,
            "field": "openid",
            "description": ""
          }
        ]
      },
      "examples": [
        {
          "title": "请求参数示例",
          "content": "openid=05J",
          "type": "json"
        }
      ]
    },
    "success": {
      "fields": {
        "响应结果": [
          {
            "group": "响应结果",
            "type": "Array",
            "optional": false,
            "field": "response",
            "description": ""
          },
          {
            "group": "响应结果",
            "type": "String",
            "optional": false,
            "field": "response.postId",
            "description": "<p>每条帖子的唯一标识</p>"
          },
          {
            "group": "响应结果",
            "type": "String",
            "optional": false,
            "field": "response.openid",
            "description": "<p>用户的openid</p>"
          },
          {
            "group": "响应结果",
            "type": "String",
            "optional": false,
            "field": "response.school",
            "description": "<p>用的学校</p>"
          },
          {
            "group": "响应结果",
            "type": "String",
            "optional": false,
            "field": "response.content",
            "description": "<p>每条帖子的内容</p>"
          },
          {
            "group": "响应结果",
            "type": "Number",
            "optional": false,
            "field": "response.time",
            "description": "<p>帖子的发布时间</p>"
          },
          {
            "group": "响应结果",
            "type": "Array",
            "optional": false,
            "field": "response.arraylist",
            "description": "<p>这个是帖子的图片加载路径数组</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "响应结果示例",
          "content": "[{\"school\":\"Fck4VA0fJ\",\"openid\":\"ughWyHW3VK\",\"postId\":\"siLD0\",\"time\":1819098654762,\"arraylist\":[\"nqkNYTl7v\"],\"content\":\"L7aQmbIbNL\"}]",
          "type": "json"
        }
      ]
    },
    "filename": "src/main/java/com/example/jingtao/contrller/PostController.java",
    "groupTitle": "PostController"
  },
  {
    "type": "GET",
    "url": "/post/getPostByOpenidLimit",
    "title": "getPostByOpenidLimit",
    "version": "4.0.0",
    "group": "PostController",
    "name": "getPostByOpenidLimit",
    "description": "<p>指定要返回的帖子条数 你可以每次刷新或者下拉调用 通过num数值达到动态刷新的效果</p>",
    "parameter": {
      "fields": {
        "请求参数": [
          {
            "group": "请求参数",
            "type": "String",
            "optional": false,
            "field": "openid",
            "description": ""
          },
          {
            "group": "请求参数",
            "type": "Number",
            "optional": false,
            "field": "num",
            "description": "<p>要返回的条子条数</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "请求参数示例",
          "content": "openid=BnhiXGGIf&num=6381",
          "type": "json"
        }
      ]
    },
    "success": {
      "fields": {
        "响应结果": [
          {
            "group": "响应结果",
            "type": "Array",
            "optional": false,
            "field": "response",
            "description": ""
          },
          {
            "group": "响应结果",
            "type": "String",
            "optional": false,
            "field": "response.postId",
            "description": ""
          },
          {
            "group": "响应结果",
            "type": "String",
            "optional": false,
            "field": "response.openid",
            "description": ""
          },
          {
            "group": "响应结果",
            "type": "String",
            "optional": false,
            "field": "response.school",
            "description": ""
          },
          {
            "group": "响应结果",
            "type": "String",
            "optional": false,
            "field": "response.content",
            "description": ""
          },
          {
            "group": "响应结果",
            "type": "Number",
            "optional": false,
            "field": "response.time",
            "description": ""
          },
          {
            "group": "响应结果",
            "type": "Array",
            "optional": false,
            "field": "response.arraylist",
            "description": ""
          }
        ]
      },
      "examples": [
        {
          "title": "响应结果示例",
          "content": "[{\"school\":\"p\",\"openid\":\"5Qe6Y\",\"postId\":\"j0\",\"time\":1062002455722,\"arraylist\":[\"y5ova\"],\"content\":\"qZKG\"}]",
          "type": "json"
        }
      ]
    },
    "filename": "src/main/java/com/example/jingtao/contrller/PostController.java",
    "groupTitle": "PostController"
  },
  {
    "type": "GET",
    "url": "/post/getPostBySchool",
    "title": "getPostBySchool",
    "version": "4.0.0",
    "group": "PostController",
    "name": "getPostBySchool",
    "description": "<p>获取一个学校的所有帖子</p>",
    "parameter": {
      "fields": {
        "请求参数": [
          {
            "group": "请求参数",
            "type": "String",
            "optional": false,
            "field": "school",
            "description": ""
          }
        ]
      },
      "examples": [
        {
          "title": "请求参数示例",
          "content": "school=4",
          "type": "json"
        }
      ]
    },
    "success": {
      "fields": {
        "响应结果": [
          {
            "group": "响应结果",
            "type": "Array",
            "optional": false,
            "field": "response",
            "description": ""
          },
          {
            "group": "响应结果",
            "type": "String",
            "optional": false,
            "field": "response.postId",
            "description": ""
          },
          {
            "group": "响应结果",
            "type": "String",
            "optional": false,
            "field": "response.openid",
            "description": ""
          },
          {
            "group": "响应结果",
            "type": "String",
            "optional": false,
            "field": "response.school",
            "description": ""
          },
          {
            "group": "响应结果",
            "type": "String",
            "optional": false,
            "field": "response.content",
            "description": ""
          },
          {
            "group": "响应结果",
            "type": "Number",
            "optional": false,
            "field": "response.time",
            "description": ""
          },
          {
            "group": "响应结果",
            "type": "Array",
            "optional": false,
            "field": "response.arraylist",
            "description": ""
          }
        ]
      },
      "examples": [
        {
          "title": "响应结果示例",
          "content": "[{\"school\":\"2BO64L\",\"openid\":\"tk91V1\",\"postId\":\"Rsn\",\"time\":545597965185,\"arraylist\":[\"lix0\"],\"content\":\"t\"}]",
          "type": "json"
        }
      ]
    },
    "filename": "src/main/java/com/example/jingtao/contrller/PostController.java",
    "groupTitle": "PostController"
  },
  {
    "type": "GET",
    "url": "/post/getPostBySchoolLimit",
    "title": "getPostBySchoolLimit",
    "version": "4.0.0",
    "group": "PostController",
    "name": "getPostBySchoolLimit",
    "description": "<p>获取一个学校指定数量的帖子 可动态刷新</p>",
    "parameter": {
      "fields": {
        "请求参数": [
          {
            "group": "请求参数",
            "type": "String",
            "optional": false,
            "field": "school",
            "description": ""
          },
          {
            "group": "请求参数",
            "type": "Number",
            "optional": false,
            "field": "num",
            "description": "<p>要返回的数目</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "请求参数示例",
          "content": "school=N1&num=5745",
          "type": "json"
        }
      ]
    },
    "success": {
      "fields": {
        "响应结果": [
          {
            "group": "响应结果",
            "type": "Array",
            "optional": false,
            "field": "response",
            "description": ""
          },
          {
            "group": "响应结果",
            "type": "String",
            "optional": false,
            "field": "response.postId",
            "description": ""
          },
          {
            "group": "响应结果",
            "type": "String",
            "optional": false,
            "field": "response.openid",
            "description": ""
          },
          {
            "group": "响应结果",
            "type": "String",
            "optional": false,
            "field": "response.school",
            "description": ""
          },
          {
            "group": "响应结果",
            "type": "String",
            "optional": false,
            "field": "response.content",
            "description": ""
          },
          {
            "group": "响应结果",
            "type": "Number",
            "optional": false,
            "field": "response.time",
            "description": ""
          },
          {
            "group": "响应结果",
            "type": "Array",
            "optional": false,
            "field": "response.arraylist",
            "description": ""
          }
        ]
      },
      "examples": [
        {
          "title": "响应结果示例",
          "content": "[{\"school\":\"DiT92\",\"openid\":\"8CiWQ7o\",\"postId\":\"1sAhkTdm\",\"time\":1902403681338,\"arraylist\":[\"im8Nu4tY\"],\"content\":\"l\"}]",
          "type": "json"
        }
      ]
    },
    "filename": "src/main/java/com/example/jingtao/contrller/PostController.java",
    "groupTitle": "PostController"
  },
  {
    "type": "POST",
    "url": "/news/addASchoolNews",
    "title": "addASchoolNews",
    "version": "3.0.0",
    "group": "SchoolNewsController",
    "name": "addASchoolNews",
    "description": "<p>添加一个校园新闻、头条 用户页面不做这个 这个由web端管理员发布</p>",
    "parameter": {
      "fields": {
        "请求参数": [
          {
            "group": "请求参数",
            "type": "String",
            "optional": false,
            "field": "title",
            "description": "<p>新闻题目</p>"
          },
          {
            "group": "请求参数",
            "type": "String",
            "optional": false,
            "field": "content",
            "description": "<p>内容</p>"
          },
          {
            "group": "请求参数",
            "type": "Object",
            "optional": false,
            "field": "file",
            "description": "<p>图片</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "请求参数示例",
          "content": "<form action=\"http://localhost:8080/news/addASchoolNews\" enctype=\"multipart/form-data\" method=\"post\">\n        <input type=\"text\" name=\"title\" placeholder=\"title\">\n        <input type=\"text\" name=\"content\" placeholder=\"content\">\n        <input type=\"file\" name=\"file\"> html通过这个来加载本地图片资源\n        <input type=\"submit\" value=\"上传\">\n    </form>",
          "type": "json"
        }
      ]
    },
    "success": {
      "fields": {
        "响应结果": [
          {
            "group": "响应结果",
            "type": "Number",
            "optional": false,
            "field": "code",
            "description": ""
          },
          {
            "group": "响应结果",
            "type": "String",
            "optional": false,
            "field": "msg",
            "description": ""
          },
          {
            "group": "响应结果",
            "type": "Object",
            "optional": false,
            "field": "data",
            "description": "<p>null</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "响应结果示例",
          "content": "{\"msg\":\"8\",\"code\":4474,\"data\":{}}",
          "type": "json"
        }
      ]
    },
    "filename": "src/main/java/com/example/jingtao/contrller/SchoolNewsController.java",
    "groupTitle": "SchoolNewsController"
  },
  {
    "type": "GET",
    "url": "/news/deleteSchoolNewsByTitle",
    "title": "deleteSchoolNewsByTitle",
    "version": "3.0.0",
    "group": "SchoolNewsController",
    "name": "deleteSchoolNewsByTitle",
    "description": "<p>根据title来删除一条新闻 用户页面不做这个 这个由web端管理员来操作</p>",
    "parameter": {
      "fields": {
        "请求参数": [
          {
            "group": "请求参数",
            "type": "String",
            "optional": false,
            "field": "title",
            "description": "<p>新闻的title</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "请求参数示例",
          "content": "title=EJEp2wQ",
          "type": "json"
        }
      ]
    },
    "success": {
      "fields": {
        "响应结果": [
          {
            "group": "响应结果",
            "type": "Number",
            "optional": false,
            "field": "code",
            "description": ""
          },
          {
            "group": "响应结果",
            "type": "String",
            "optional": false,
            "field": "msg",
            "description": ""
          },
          {
            "group": "响应结果",
            "type": "Object",
            "optional": false,
            "field": "data",
            "description": "<p>null</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "响应结果示例",
          "content": "{\"msg\":\"68fBVEaKw\",\"code\":328,\"data\":{}}",
          "type": "json"
        }
      ]
    },
    "filename": "src/main/java/com/example/jingtao/contrller/SchoolNewsController.java",
    "groupTitle": "SchoolNewsController"
  },
  {
    "type": "GET",
    "url": "/news/getAllSchoolNews",
    "title": "getAllSchoolNews",
    "version": "3.0.0",
    "group": "SchoolNewsController",
    "name": "getAllSchoolNews",
    "description": "<p>获得校园新闻、头条记录 没有请求参数</p>",
    "success": {
      "fields": {
        "响应结果": [
          {
            "group": "响应结果",
            "type": "Number",
            "optional": false,
            "field": "code",
            "description": ""
          },
          {
            "group": "响应结果",
            "type": "String",
            "optional": false,
            "field": "msg",
            "description": ""
          },
          {
            "group": "响应结果",
            "type": "Object",
            "optional": false,
            "field": "data",
            "description": "<p>data里放的是一个新闻的数组</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "响应结果示例",
          "content": "{\n\"code\": 1,\n\"msg\": \"ok\",\n\"data\": [\n{\n\"title\": \"山东大学第二届运动会\",\n\"content\": \"egerbhsvcbwbvuvwqwquiowebvubewv\",\n\"img_src\": \"/news/getImg?title=山东大学第二届运动会\",  //img_src是为了方便前端获取图片资源设置的图片资源访问路径\n\"time\": \"2021-05-16T04:17:24.000+00:00\"   //发布的时间 可以根据这个来排序\n},\n{\n\"title\": \"软件学院山大地玮杯\",\n\"content\": \"全国无是凤求凰微积分ifVB差几年内物权法是重庆楼盘为你欧服报卡不好   不犯法请问 静悄悄好亲切额 无诶饥饿吧菊 企鹅群文件就去发额编辑器就无法发\",\n\"img_src\": \"/news/getImg?title=软件学院山大地玮杯\",\n\"time\": \"2021-05-16T04:19:22.000+00:00\"\n}\n]\n}",
          "type": "json"
        }
      ]
    },
    "filename": "src/main/java/com/example/jingtao/contrller/SchoolNewsController.java",
    "groupTitle": "SchoolNewsController"
  },
  {
    "type": "GET",
    "url": "/news/getImg",
    "title": "getImg",
    "version": "3.0.0",
    "group": "SchoolNewsController",
    "name": "getImg",
    "description": "<p>你根据这个接口来获取图片资源</p>",
    "parameter": {
      "fields": {
        "请求参数": [
          {
            "group": "请求参数",
            "type": "String",
            "optional": false,
            "field": "title",
            "description": ""
          }
        ]
      },
      "examples": [
        {
          "title": "请求参数示例",
          "content": "<img src= img_src /> 直接让src等于我发给你的img_src字段 即可加载图片资源",
          "type": "json"
        }
      ]
    },
    "success": {
      "fields": {
        "响应结果": [
          {
            "group": "响应结果",
            "type": "Object",
            "optional": false,
            "field": "response",
            "description": ""
          }
        ]
      },
      "examples": [
        {
          "title": "响应结果示例",
          "content": "null",
          "type": "json"
        }
      ]
    },
    "filename": "src/main/java/com/example/jingtao/contrller/SchoolNewsController.java",
    "groupTitle": "SchoolNewsController"
  },
  {
    "type": "POST",
    "url": "/user/addAUser",
    "title": "addAUser",
    "version": "1.0.0",
    "group": "UserController",
    "name": "addAUser",
    "description": "<p>添加一个用户</p>",
    "parameter": {
      "fields": {
        "请求参数": [
          {
            "group": "请求参数",
            "type": "String",
            "optional": false,
            "field": "openid",
            "description": "<p>openid给我 这是唯一标识用户的主键</p>"
          },
          {
            "group": "请求参数",
            "type": "String",
            "optional": false,
            "field": "school",
            "description": "<p>学校</p>"
          },
          {
            "group": "请求参数",
            "type": "String",
            "optional": false,
            "field": "college",
            "description": "<p>学院</p>"
          },
          {
            "group": "请求参数",
            "type": "String",
            "optional": false,
            "field": "major",
            "description": "<p>专业</p>"
          },
          {
            "group": "请求参数",
            "type": "Number",
            "optional": false,
            "field": "grade",
            "description": "<p>年级</p>"
          },
          {
            "group": "请求参数",
            "type": "String",
            "optional": false,
            "field": "banji",
            "description": "<p>班级 class是关键字 所以用拼音了</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "请求参数示例",
          "content": "college=fdV2fP&major=wi5Db4O&school=Te0j&openid=L28gN&grade=6293&banji=88l",
          "type": "json"
        }
      ]
    },
    "success": {
      "fields": {
        "响应结果": [
          {
            "group": "响应结果",
            "type": "Number",
            "optional": false,
            "field": "code",
            "description": ""
          },
          {
            "group": "响应结果",
            "type": "String",
            "optional": false,
            "field": "msg",
            "description": ""
          },
          {
            "group": "响应结果",
            "type": "Object",
            "optional": false,
            "field": "data",
            "description": ""
          }
        ]
      },
      "examples": [
        {
          "title": "响应结果示例",
          "content": "{\"msg\":\"nSP0\",\"code\":2192,\"data\":{}}",
          "type": "json"
        }
      ]
    },
    "filename": "src/main/java/com/example/jingtao/contrller/UserController.java",
    "groupTitle": "UserController"
  },
  {
    "type": "POST",
    "url": "/user/getUser",
    "title": "getUser",
    "version": "1.0.0",
    "group": "UserController",
    "name": "getUser",
    "description": "<p>根据openid获取用户信息</p>",
    "parameter": {
      "fields": {
        "请求参数": [
          {
            "group": "请求参数",
            "type": "String",
            "optional": false,
            "field": "openid",
            "description": "<p>你存在微信里的openid</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "请求参数示例",
          "content": "openid=0Szk",
          "type": "json"
        }
      ]
    },
    "success": {
      "fields": {
        "响应结果": [
          {
            "group": "响应结果",
            "type": "Number",
            "optional": false,
            "field": "code",
            "description": ""
          },
          {
            "group": "响应结果",
            "type": "String",
            "optional": false,
            "field": "msg",
            "description": ""
          },
          {
            "group": "响应结果",
            "type": "Object",
            "optional": false,
            "field": "data",
            "description": ""
          }
        ]
      },
      "examples": [
        {
          "title": "响应结果示例",
          "content": "{\"msg\":\"wGaG5S6E\",\"code\":9797,\"data\":{}}",
          "type": "json"
        }
      ]
    },
    "filename": "src/main/java/com/example/jingtao/contrller/UserController.java",
    "groupTitle": "UserController"
  },
  {
    "type": "POST",
    "url": "/user/selectByBanji",
    "title": "selectByBanji",
    "version": "1.0.0",
    "group": "UserController",
    "name": "selectByBanji",
    "description": "<p>返回你的同班同学信息 然后你可以去蹭他们选的课</p>",
    "parameter": {
      "fields": {
        "请求参数": [
          {
            "group": "请求参数",
            "type": "String",
            "optional": false,
            "field": "school",
            "description": "<p>学校</p>"
          },
          {
            "group": "请求参数",
            "type": "String",
            "optional": false,
            "field": "college",
            "description": "<p>学院</p>"
          },
          {
            "group": "请求参数",
            "type": "String",
            "optional": false,
            "field": "major",
            "description": "<p>专业</p>"
          },
          {
            "group": "请求参数",
            "type": "Number",
            "optional": false,
            "field": "grade",
            "description": "<p>年级</p>"
          },
          {
            "group": "请求参数",
            "type": "String",
            "optional": false,
            "field": "banji",
            "description": "<p>班级</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "请求参数示例",
          "content": "college=L2hdU1MEvb&major=80Xf&school=yGxOPAqQL&grade=6220&banji=qvqAUHZtzT",
          "type": "json"
        }
      ]
    },
    "success": {
      "fields": {
        "响应结果": [
          {
            "group": "响应结果",
            "type": "Number",
            "optional": false,
            "field": "code",
            "description": ""
          },
          {
            "group": "响应结果",
            "type": "String",
            "optional": false,
            "field": "msg",
            "description": ""
          },
          {
            "group": "响应结果",
            "type": "Object",
            "optional": false,
            "field": "data",
            "description": ""
          }
        ]
      },
      "examples": [
        {
          "title": "响应结果示例",
          "content": "{\"msg\":\"b3B7\",\"code\":461,\"data\":{}}",
          "type": "json"
        }
      ]
    },
    "filename": "src/main/java/com/example/jingtao/contrller/UserController.java",
    "groupTitle": "UserController"
  },
  {
    "type": "POST",
    "url": "/user/selectByGrade",
    "title": "selectByGrade",
    "version": "1.0.0",
    "group": "UserController",
    "name": "selectByGrade",
    "description": "<p>返回你的同年级同学信息 用来看他们的选课 蹭课</p>",
    "parameter": {
      "fields": {
        "请求参数": [
          {
            "group": "请求参数",
            "type": "String",
            "optional": false,
            "field": "school",
            "description": "<p>学校</p>"
          },
          {
            "group": "请求参数",
            "type": "String",
            "optional": false,
            "field": "college",
            "description": "<p>学院</p>"
          },
          {
            "group": "请求参数",
            "type": "String",
            "optional": false,
            "field": "major",
            "description": "<p>专业</p>"
          },
          {
            "group": "请求参数",
            "type": "Number",
            "optional": false,
            "field": "grade",
            "description": "<p>年级</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "请求参数示例",
          "content": "college=wNr0k1QlT5&major=j08wL2zisa&school=UigO&grade=4168",
          "type": "json"
        }
      ]
    },
    "success": {
      "fields": {
        "响应结果": [
          {
            "group": "响应结果",
            "type": "Number",
            "optional": false,
            "field": "code",
            "description": ""
          },
          {
            "group": "响应结果",
            "type": "String",
            "optional": false,
            "field": "msg",
            "description": ""
          },
          {
            "group": "响应结果",
            "type": "Object",
            "optional": false,
            "field": "data",
            "description": ""
          }
        ]
      },
      "examples": [
        {
          "title": "响应结果示例",
          "content": "{\"msg\":\"RY\",\"code\":7171,\"data\":{}}",
          "type": "json"
        }
      ]
    },
    "filename": "src/main/java/com/example/jingtao/contrller/UserController.java",
    "groupTitle": "UserController"
  },
  {
    "type": "POST",
    "url": "/user/updateUser",
    "title": "updateUser",
    "version": "1.0.0",
    "group": "UserController",
    "name": "updateUser",
    "description": "<p>更新一个用户</p>",
    "parameter": {
      "fields": {
        "请求参数": [
          {
            "group": "请求参数",
            "type": "String",
            "optional": false,
            "field": "openid",
            "description": "<p>openid</p>"
          },
          {
            "group": "请求参数",
            "type": "String",
            "optional": false,
            "field": "school",
            "description": "<p>学校</p>"
          },
          {
            "group": "请求参数",
            "type": "String",
            "optional": false,
            "field": "college",
            "description": "<p>学院</p>"
          },
          {
            "group": "请求参数",
            "type": "String",
            "optional": false,
            "field": "major",
            "description": "<p>专业</p>"
          },
          {
            "group": "请求参数",
            "type": "Number",
            "optional": false,
            "field": "grade",
            "description": "<p>年级</p>"
          },
          {
            "group": "请求参数",
            "type": "String",
            "optional": false,
            "field": "banji",
            "description": "<p>班级</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "请求参数示例",
          "content": "college=nEnb0l8oaS&major=wPgxYW&school=My&openid=AzKJMlFW&grade=4591&banji=XbM",
          "type": "json"
        }
      ]
    },
    "success": {
      "fields": {
        "响应结果": [
          {
            "group": "响应结果",
            "type": "Number",
            "optional": false,
            "field": "code",
            "description": ""
          },
          {
            "group": "响应结果",
            "type": "String",
            "optional": false,
            "field": "msg",
            "description": ""
          },
          {
            "group": "响应结果",
            "type": "Object",
            "optional": false,
            "field": "data",
            "description": ""
          }
        ]
      },
      "examples": [
        {
          "title": "响应结果示例",
          "content": "{\"msg\":\"zr8xKba\",\"code\":4082,\"data\":{}}",
          "type": "json"
        }
      ]
    },
    "filename": "src/main/java/com/example/jingtao/contrller/UserController.java",
    "groupTitle": "UserController"
  }
] });