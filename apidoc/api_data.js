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
    "type": "POST",
    "url": "/note/getContacter",
    "title": "getContacter",
    "version": "9.0.0",
    "group": "NoteController",
    "name": "getContacter",
    "description": "<p>用户获取联系人列表  并判断是否有新消息</p>",
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
          "content": "openid=8wQwAPbQ",
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
            "field": "response.openid",
            "description": "<p>联系人openid</p>"
          },
          {
            "group": "响应结果",
            "type": "String",
            "optional": false,
            "field": "response.nickname",
            "description": "<p>联系人昵称</p>"
          },
          {
            "group": "响应结果",
            "type": "String",
            "optional": false,
            "field": "response.headImg",
            "description": "<p>联系人头像</p>"
          },
          {
            "group": "响应结果",
            "type": "Number",
            "optional": false,
            "field": "response.note",
            "description": "<p>该联系人是否发来了新消息   0为存在新消息，需要提醒用户查看   1为没有</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "响应结果示例",
          "content": "[{\"note\":405,\"headImg\":\"i\",\"openid\":\"EFNAlgyn\",\"nickname\":\"IewaH565\"}]",
          "type": "json"
        }
      ]
    },
    "filename": "src/main/java/com/example/jingtao/contrller/NoteController.java",
    "groupTitle": "NoteController"
  },
  {
    "type": "POST",
    "url": "/note/getNotes",
    "title": "getNotes",
    "version": "9.0.0",
    "group": "NoteController",
    "name": "getNotes",
    "description": "<p>得到你与这个联系人的聊天记录</p>",
    "parameter": {
      "fields": {
        "请求参数": [
          {
            "group": "请求参数",
            "type": "String",
            "optional": false,
            "field": "myOpenid",
            "description": "<p>本用户的openid</p>"
          },
          {
            "group": "请求参数",
            "type": "String",
            "optional": false,
            "field": "otherOpenid",
            "description": "<p>联系人的openid</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "请求参数示例",
          "content": "otherOpenid=t3SbbacodQ&myOpenid=tmWc",
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
            "type": "Object",
            "optional": false,
            "field": "response.sender",
            "description": "<p>发送者对象</p>"
          },
          {
            "group": "响应结果",
            "type": "String",
            "optional": false,
            "field": "response.sender.openid",
            "description": ""
          },
          {
            "group": "响应结果",
            "type": "String",
            "optional": false,
            "field": "response.sender.nickname",
            "description": ""
          },
          {
            "group": "响应结果",
            "type": "String",
            "optional": false,
            "field": "response.sender.headImg",
            "description": ""
          },
          {
            "group": "响应结果",
            "type": "Object",
            "optional": false,
            "field": "response.accepter",
            "description": "<p>接受者对象</p>"
          },
          {
            "group": "响应结果",
            "type": "String",
            "optional": false,
            "field": "response.accepter.openid",
            "description": ""
          },
          {
            "group": "响应结果",
            "type": "String",
            "optional": false,
            "field": "response.accepter.nickname",
            "description": ""
          },
          {
            "group": "响应结果",
            "type": "String",
            "optional": false,
            "field": "response.accepter.headImg",
            "description": ""
          },
          {
            "group": "响应结果",
            "type": "String",
            "optional": false,
            "field": "response.message",
            "description": "<p>消息内容</p>"
          },
          {
            "group": "响应结果",
            "type": "String",
            "optional": false,
            "field": "response.time",
            "description": "<p>发送消息 的时间</p>"
          },
          {
            "group": "响应结果",
            "type": "Number",
            "optional": false,
            "field": "response.look",
            "description": "<p>该消息是否已被接受者读到   已读为1  未读为0</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "响应结果示例",
          "content": "[{\"sender\":{\"headImg\":\"4Spr\",\"openid\":\"NOB8tLM\",\"nickname\":\"RW7M\"},\"accepter\":{\"headImg\":\"Ot\",\"openid\":\"Bz\",\"nickname\":\"6\"},\"time\":\"l\",\"message\":\"iv9uvCG28E\",\"look\":5952}]",
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
    "url": "/post/getAllFistPagePost",
    "title": "getAllFistPagePost",
    "version": "7.0.0",
    "group": "PostController",
    "name": "getAllFistPagePost",
    "description": "<p>在所有帖子里 查询第一页</p>",
    "parameter": {
      "fields": {
        "请求参数": [
          {
            "group": "请求参数",
            "type": "String",
            "optional": false,
            "field": "page",
            "description": ""
          },
          {
            "group": "请求参数",
            "type": "String",
            "optional": false,
            "field": "num",
            "description": ""
          }
        ]
      },
      "examples": [
        {
          "title": "请求参数示例",
          "content": "num=F5FaLm6o&page=PsPyW1",
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
            "description": "<p>同根据学校查询第一页</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "响应结果示例",
          "content": "{}",
          "type": "json"
        }
      ]
    },
    "filename": "src/main/java/com/example/jingtao/contrller/PostController.java",
    "groupTitle": "PostController"
  },
  {
    "type": "GET",
    "url": "/post/getAllPagePost",
    "title": "getAllPagePost",
    "version": "7.0.0",
    "group": "PostController",
    "name": "getAllPagePost",
    "description": "<p>查询所有帖子的第2 3 4 5.....页</p>",
    "parameter": {
      "fields": {
        "请求参数": [
          {
            "group": "请求参数",
            "type": "String",
            "optional": false,
            "field": "page",
            "description": ""
          },
          {
            "group": "请求参数",
            "type": "String",
            "optional": false,
            "field": "num",
            "description": ""
          },
          {
            "group": "请求参数",
            "type": "String",
            "optional": false,
            "field": "time",
            "description": "<p>第一次查询时返回给你的时间</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "请求参数示例",
          "content": "num=ONqoIXjNlw&page=A&time=uPmL6Ge",
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
            "type": "Object",
            "optional": false,
            "field": "response.data",
            "description": ""
          },
          {
            "group": "响应结果",
            "type": "Object",
            "optional": false,
            "field": "response.userInf",
            "description": ""
          },
          {
            "group": "响应结果",
            "type": "String",
            "optional": false,
            "field": "response.userInf.openid",
            "description": "<p>This field was generated by MyBatis Generator.      This field corresponds to the database column userinf.openid</p>"
          },
          {
            "group": "响应结果",
            "type": "String",
            "optional": false,
            "field": "response.userInf.nickname",
            "description": "<p>This field was generated by MyBatis Generator.      This field corresponds to the database column userinf.nickname</p>"
          },
          {
            "group": "响应结果",
            "type": "String",
            "optional": false,
            "field": "response.userInf.headImg",
            "description": "<p>This field was generated by MyBatis Generator.      This field corresponds to the database column userinf.head_img</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "响应结果示例",
          "content": "[{\"data\":{},\"userInf\":{\"headImg\":\"nk\",\"openid\":\"aX80hBIr\",\"nickname\":\"PB3sC5\"}}]",
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
    "type": "GET",
    "url": "/post/getFirstPagePostBySchool",
    "title": "getFirstPagePostBySchool",
    "version": "7.0.0",
    "group": "PostController",
    "name": "getFirstPagePostBySchool",
    "description": "<p>根据学校分页查询帖子 获得第一页 会返回给你time 此后每次请求带上time</p>",
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
            "type": "String",
            "optional": false,
            "field": "page",
            "description": ""
          },
          {
            "group": "请求参数",
            "type": "String",
            "optional": false,
            "field": "num",
            "description": ""
          }
        ]
      },
      "examples": [
        {
          "title": "请求参数示例",
          "content": "school=mP6c&num=AvfzYKcts&page=Fn46Il6S",
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
            "description": "<p>返回的是一个map集合 一个字段time是时间 一个字段postlist是返回帖子列表</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "响应结果示例",
          "content": "{}",
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
    "url": "/post/getPagePostByOpenid",
    "title": "getPagePostByOpenid",
    "version": "7.0.0",
    "group": "PostController",
    "name": "getPagePostByOpenid",
    "description": "<p>根据openid分页查询</p>",
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
            "field": "page",
            "description": "<p>第几页</p>"
          },
          {
            "group": "请求参数",
            "type": "String",
            "optional": false,
            "field": "num",
            "description": "<p>每页有多少数目</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "请求参数示例",
          "content": "openid=Ntbm&num=hNxFua&page=KgeSiJXOS",
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
            "type": "Object",
            "optional": false,
            "field": "response.data",
            "description": ""
          },
          {
            "group": "响应结果",
            "type": "Object",
            "optional": false,
            "field": "response.userInf",
            "description": ""
          },
          {
            "group": "响应结果",
            "type": "String",
            "optional": false,
            "field": "response.userInf.openid",
            "description": "<p>This field was generated by MyBatis Generator.      This field corresponds to the database column userinf.openid</p>"
          },
          {
            "group": "响应结果",
            "type": "String",
            "optional": false,
            "field": "response.userInf.nickname",
            "description": "<p>This field was generated by MyBatis Generator.      This field corresponds to the database column userinf.nickname</p>"
          },
          {
            "group": "响应结果",
            "type": "String",
            "optional": false,
            "field": "response.userInf.headImg",
            "description": "<p>This field was generated by MyBatis Generator.      This field corresponds to the database column userinf.head_img</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "响应结果示例",
          "content": "[{\"data\":{},\"userInf\":{\"headImg\":\"f\",\"openid\":\"7EBbOt\",\"nickname\":\"Ive9\"}}]",
          "type": "json"
        }
      ]
    },
    "filename": "src/main/java/com/example/jingtao/contrller/PostController.java",
    "groupTitle": "PostController"
  },
  {
    "type": "POST",
    "url": "/post/getPagePostBySchool",
    "title": "getPagePostBySchool",
    "version": "7.0.0",
    "group": "PostController",
    "name": "getPagePostBySchool",
    "description": "<p>根据学校分页查询 第2 3 4....页</p>",
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
            "type": "String",
            "optional": false,
            "field": "page",
            "description": ""
          },
          {
            "group": "请求参数",
            "type": "String",
            "optional": false,
            "field": "num",
            "description": ""
          },
          {
            "group": "请求参数",
            "type": "String",
            "optional": false,
            "field": "time",
            "description": "<p>查询第一页发给你的time</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "请求参数示例",
          "content": "school=jkw1QV&num=AQc3twMBJ&page=bcdv5oP&time=W",
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
            "type": "Object",
            "optional": false,
            "field": "response.data",
            "description": ""
          },
          {
            "group": "响应结果",
            "type": "Object",
            "optional": false,
            "field": "response.userInf",
            "description": ""
          },
          {
            "group": "响应结果",
            "type": "String",
            "optional": false,
            "field": "response.userInf.openid",
            "description": "<p>This field was generated by MyBatis Generator.      This field corresponds to the database column userinf.openid</p>"
          },
          {
            "group": "响应结果",
            "type": "String",
            "optional": false,
            "field": "response.userInf.nickname",
            "description": "<p>This field was generated by MyBatis Generator.      This field corresponds to the database column userinf.nickname</p>"
          },
          {
            "group": "响应结果",
            "type": "String",
            "optional": false,
            "field": "response.userInf.headImg",
            "description": "<p>This field was generated by MyBatis Generator.      This field corresponds to the database column userinf.head_img</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "响应结果示例",
          "content": "[{\"data\":{},\"userInf\":{\"headImg\":\"JAdUl\",\"openid\":\"Moh2Y\",\"nickname\":\"PftjU0xcr\"}}]",
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
    "version": "7.0.0",
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
          "content": "openid=Hi",
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
            "type": "Object",
            "optional": false,
            "field": "response.data",
            "description": "<p>data里放的是一条post</p>"
          },
          {
            "group": "响应结果",
            "type": "Object",
            "optional": false,
            "field": "response.userInf",
            "description": "<p>补全的对应userinfo信息</p>"
          },
          {
            "group": "响应结果",
            "type": "String",
            "optional": false,
            "field": "response.userInf.openid",
            "description": ""
          },
          {
            "group": "响应结果",
            "type": "String",
            "optional": false,
            "field": "response.userInf.nickname",
            "description": ""
          },
          {
            "group": "响应结果",
            "type": "String",
            "optional": false,
            "field": "response.userInf.headImg",
            "description": ""
          }
        ]
      },
      "examples": [
        {
          "title": "响应结果示例",
          "content": "[{\"data\":{},\"userInf\":{\"headImg\":\"AIHX\",\"openid\":\"qkP\",\"nickname\":\"ZDoMd\"}}]",
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
          "content": "<form action=\"http://localhost:8080/news/addASchoolNews\" enctype=\"multipart/form-data\" method=\"post\">\n<input type=\"text\" name=\"title\" placeholder=\"title\">\n<input type=\"text\" name=\"content\" placeholder=\"content\">\n<input type=\"file\" name=\"file\"> html通过这个来加载本地图片资源\n<input type=\"submit\" value=\"上传\">\n</form>",
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
    "type": "POST",
    "url": "/news/getFirstPageSchoolNews",
    "title": "getFirstPageSchoolNews",
    "version": "8.0.0",
    "group": "SchoolNewsController",
    "name": "getFirstPageSchoolNews",
    "description": "<p>获取头条的第一页</p>",
    "parameter": {
      "fields": {
        "请求参数": [
          {
            "group": "请求参数",
            "type": "String",
            "optional": false,
            "field": "page",
            "description": ""
          },
          {
            "group": "请求参数",
            "type": "String",
            "optional": false,
            "field": "num",
            "description": ""
          }
        ]
      },
      "examples": [
        {
          "title": "请求参数示例",
          "content": "num=oKfkVs&page=Wp2",
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
            "description": "<p>懒得写的 很麻烦 你直接打印出来看吧  时间已经转化成字符串封装好了</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "响应结果示例",
          "content": "{}",
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
    "type": "GET",
    "url": "/news/getPageSchoolNews",
    "title": "getPageSchoolNews",
    "version": "8.0.0",
    "group": "SchoolNewsController",
    "name": "getPageSchoolNews",
    "description": "<p>分页获取头条的2 3 4 ......页  要给我时间</p>",
    "parameter": {
      "fields": {
        "请求参数": [
          {
            "group": "请求参数",
            "type": "String",
            "optional": false,
            "field": "page",
            "description": ""
          },
          {
            "group": "请求参数",
            "type": "String",
            "optional": false,
            "field": "num",
            "description": ""
          },
          {
            "group": "请求参数",
            "type": "String",
            "optional": false,
            "field": "time",
            "description": "<p>字符串  第一页的时候发给你了</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "请求参数示例",
          "content": "num=NN&page=gaFx&time=28a",
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
            "type": "Object",
            "optional": false,
            "field": "response.data",
            "description": ""
          },
          {
            "group": "响应结果",
            "type": "Object",
            "optional": false,
            "field": "response.userInf",
            "description": ""
          },
          {
            "group": "响应结果",
            "type": "String",
            "optional": false,
            "field": "response.userInf.openid",
            "description": "<p>This field was generated by MyBatis Generator.      This field corresponds to the database column userinf.openid</p>"
          },
          {
            "group": "响应结果",
            "type": "String",
            "optional": false,
            "field": "response.userInf.nickname",
            "description": "<p>This field was generated by MyBatis Generator.      This field corresponds to the database column userinf.nickname</p>"
          },
          {
            "group": "响应结果",
            "type": "String",
            "optional": false,
            "field": "response.userInf.headImg",
            "description": "<p>This field was generated by MyBatis Generator.      This field corresponds to the database column userinf.head_img</p>"
          },
          {
            "group": "响应结果",
            "type": "String",
            "optional": false,
            "field": "response.time",
            "description": "<p>封装好的时间字符串</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "响应结果示例",
          "content": "[{\"data\":{},\"time\":\"FZvqalr8\",\"userInf\":{\"headImg\":\"ML0K2N\",\"openid\":\"ZTv1Zx\",\"nickname\":\"1Mhep\"}}]",
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
    "version": "6.0.0",
    "group": "UserController",
    "name": "getUser",
    "description": "<p>根据openid获取用户信息 返回结果封装了一层 对象携带头像和昵称</p>",
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
    "version": "6.0.0",
    "group": "UserController",
    "name": "selectByBanji",
    "description": "<p>返回你的同班同学信息 然后你可以去蹭他们选的课 返回结果封装了一层 对象携带头像和昵称</p>",
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
            "type": "String",
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
          "content": "college=kAKfyeKoG&major=8F698WZ5&school=tB15T&grade=q&banji=pifj",
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
          "content": "{\"msg\":\"jfH\",\"code\":2196,\"data\":{}}",
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
    "version": "6.0.0",
    "group": "UserController",
    "name": "selectByGrade",
    "description": "<p>返回你的同年级同学信息 用来看他们的选课 蹭课 返回结果封装了一层 对象携带头像和昵称</p>",
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
            "type": "String",
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
  },
  {
    "type": "POST",
    "url": "/userInf/addAUserInf",
    "title": "addAUserInf",
    "version": "6.0.0",
    "group": "UserInfController",
    "name": "addAUserInf",
    "description": "<p>添加一个用户信息 openid  昵称 头像链接</p>",
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
            "field": "nickname",
            "description": ""
          },
          {
            "group": "请求参数",
            "type": "String",
            "optional": false,
            "field": "headImg",
            "description": ""
          }
        ]
      },
      "examples": [
        {
          "title": "请求参数示例",
          "content": "headImg=jKwZ8chi4W&openid=qxKx&nickname=c4l",
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
          "content": "{\"msg\":\"15VKd\",\"code\":4128,\"data\":{}}",
          "type": "json"
        }
      ]
    },
    "filename": "src/main/java/com/example/jingtao/contrller/UserInfController.java",
    "groupTitle": "UserInfController"
  },
  {
    "type": "POST",
    "url": "/userInf/getUserInfByOpenid",
    "title": "getUserInfByOpenid",
    "version": "6.0.0",
    "group": "UserInfController",
    "name": "getUserInfByOpenid",
    "description": "<p>通过openid获取用户信息  可以判断该用户是否已经存在信息 来决定调用更新还是增加</p>",
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
          "content": "openid=0XfWY",
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
          "content": "{\"msg\":\"GlNdhP3huo\",\"code\":1548,\"data\":{}}",
          "type": "json"
        }
      ]
    },
    "filename": "src/main/java/com/example/jingtao/contrller/UserInfController.java",
    "groupTitle": "UserInfController"
  },
  {
    "type": "POST",
    "url": "/userInf/updateUserInf",
    "title": "updateUserInf",
    "version": "6.0.0",
    "group": "UserInfController",
    "name": "updateUserInf",
    "description": "<p>更新一个用户信息</p>",
    "parameter": {
      "fields": {
        "请求参数": [
          {
            "group": "请求参数",
            "type": "String",
            "optional": false,
            "field": "openid",
            "description": "<p>This field was generated by MyBatis Generator.      This field corresponds to the database column userinf.openid</p>"
          },
          {
            "group": "请求参数",
            "type": "String",
            "optional": false,
            "field": "nickname",
            "description": "<p>This field was generated by MyBatis Generator.      This field corresponds to the database column userinf.nickname</p>"
          },
          {
            "group": "请求参数",
            "type": "String",
            "optional": false,
            "field": "headImg",
            "description": "<p>This field was generated by MyBatis Generator.      This field corresponds to the database column userinf.head_img</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "请求参数示例",
          "content": "headImg=Uirs9ZI&openid=H&nickname=2GaV3",
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
          "content": "{\"msg\":\"BQC6I\",\"code\":6210,\"data\":{}}",
          "type": "json"
        }
      ]
    },
    "filename": "src/main/java/com/example/jingtao/contrller/UserInfController.java",
    "groupTitle": "UserInfController"
  }
] });
