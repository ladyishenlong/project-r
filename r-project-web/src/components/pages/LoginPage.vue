<template>

  <!--  model表单数据类型 rules 表单数据类型验证规则 -->
  <Form id="form_login" ref="userModel" :model="userModel" :rules="userRule" >

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
      login(data) {
        console.log("检查");
        this.$refs[data].validate((valid) => {
          if (valid) {
            this.$Message.success('Success!');
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
    max-width: 30%;
  }

</style>
