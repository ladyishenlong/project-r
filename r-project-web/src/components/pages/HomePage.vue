<template>
  <div class="layout">
    <layout>
      <!--  头部导航栏    -->
      <header>
        <Menu mode="horizontal" theme="dark" active-name="1">
          <div class="layout_nav">
            <menu-item name="1">
              <icon type="ios-navigate">第一项</icon>
            </menu-item>
            <menu-item name="2">
              <icon type="ios-navigate">第二项</icon>
            </menu-item>
            <menu-item name="3">
              <icon type="ios-navigate">第三项</icon>
            </menu-item>
            <menu-item name="4">
              <icon type="ios-navigate">第四项</icon>
            </menu-item>
          </div>

        </Menu>
      </header>

      <!--   中间的内容   -->
      <content>


        <Button>Default</Button>
        <Button type="primary" @click="hello">点击请求</Button>


        <Button type="dashed">Dashed</Button>
        <Button type="text">Text</Button>
        <br><br>
        <Button type="info">Info</Button>
        <Button type="success">Success</Button>
        <Button type="warning">Warning</Button>
        <Button type="error">Error</Button>


      </content>


      <footer>
        这里是底部
      </footer>


    </layout>
  </div>
</template>


<script>
  import axios from "axios";

  export default {
    name: 'HomePage',
    data() {
      return {
        msg: 'this is  HomePage'
      }
    }, methods: {
      hello: function () {
        console.log("网络请求开始");
        axios
          .get("http://localhost:8003/test/test/hello", {
            headers: {
              "content-type": "application/json;charset=UTF-8"
            }
          })
          .then(function (data) {
            alert("请求成功：" + data.data)
          })
          .catch(function (error) {
            console.log("请求异常：" + error)
          })
      }
    }
  }
</script>


<style scoped>
  .layout_nav {
    width: 420px;
    margin: 0 20px 0 auto;
  }
</style>
