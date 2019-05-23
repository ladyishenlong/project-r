<template>

  <!--  model表单数据类型 rules 表单数据类型验证规则 -->
  <Form id="form_login" ref="userModel" :model="userModel" :rules="userRule">

    <!-- prop对应表单model里面对应的字段   -->
    <FormItem prop="username">
      <Input type="text" v-model="userModel.username" placeholder="username">
        <Icon type="ios-person-outline" slot="prepend"></Icon>
      </Input>
    </FormItem>

    <FormItem prop="password">
      <Input type="password" v-model="userModel.password" placeholder="password">
        <Icon type="ios-lock-outline" slot="prepend"></Icon>
      </Input>
    </FormItem>

    <FormItem>
      <Button type="primary" @click="login('userModel')">login</Button>
    </FormItem>
  </Form>
</template>

<script>
  export default {
    name: "LoginPage",
    data() {
      return {
        userModel: {
          username: '',
          password: ''
        },
        userRule: {
          username: [
            {required: true, message: 'please fill in the username', trigger: 'blur'}
          ],
          //userModel 验证规则
          password: [
            {required: true, message: 'please fill in the password', trigger: 'blur'},
            {type: 'string', min: 3, message: 'the password length cannot be less than 3 bits', trigger: 'blur'}
          ]
        }
      }
    },
    methods: {
      login(userData) {
        console.log("检查");
        this.$refs[userData].validate((valid) => {
          if (valid) {
            console.log("开始网络请求");
            const params = new URLSearchParams();
            params.append('username', this.userModel.username);
            params.append('password', this.userModel.password);
            this.$axios
              .post("http://localhost:8003/user/login", params,
                {
                  headers: {
                    'Content-Type': 'application/x-www-form-urlencoded',
                  }
                })
              .then(result => {
                //请求成功不一定是登陆成功
                var sessionId = result.data;
                if(sessionId!=null){
                  this.$Message.success('登陆成功');
                  this.$router.push("/articleIndex");
                  //储存sessionId
                  document.cookie=sessionId
                }
              })
              .catch(error => {
                console.log("请求异常：" + error)
              });
          } else {
            this.$Message.error('Fail!');
          }
        })
      }
    }
  }
</script>

<style scoped>
  #form_login {
    width: 200px;
    padding-top: 30px;
    margin: auto;
  }

</style>
