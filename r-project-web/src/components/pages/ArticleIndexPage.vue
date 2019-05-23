<template>
  <div>
    <Layout>
      <Header>Header</Header>
      <Content>

        <Card class="myCard" :bordered="true" v-for="item in indexs"
              :key="index" @click="clickEvent(item.title)">
          <p slot="title">{{item.title}}</p>
          <p>{{item.author}}</p>
        </Card>

      </Content>
      <Footer>Footer</Footer>
    </Layout>

  </div>
</template>

<script>
  export default {
    name: "ArticleIndexPage",
    data() {
      return {
        indexs: [],
        index: {
          username: "",
          id: "",
          title: "",
          author: ""
        }
      }
    },
    methods: {

      clickEvent(event) {
        this.$Message.info("点击了："+event)
      },


      getArticleIndex() {
        console.log("获取文章列表");
        this.$axios.get("http://localhost:8003/article/article/findArticleIndexByUsername", {
          headers: {
            'x-auth-token': document.cookie
          }
        })
          .then(result => {
            console.log("请求成功：" + result.data);
            this.indexs = result.data
          })
          .catch(error => {
            console.log("请求异常：" + error)
          })
      }
    }
    , created() {
      this.getArticleIndex()
    }
  }
</script>


<style>
  .myCard {
    margin-top: 5rem;
  }


</style>
