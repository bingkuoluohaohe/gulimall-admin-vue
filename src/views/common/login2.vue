<template>
  <div class="box">
    <form>
      <h2>Login</h2>
      <div class="input-box">
        <label>账号</label>
        <input type="text" v-model="dataForm.userName" />
      </div>
      <div class="input-box">
        <label>密码</label>
        <input type="password" v-model="dataForm.password" />
      </div>
      <div class="input-box">
        <label>验证码</label>
        <input type="text" v-model="dataForm.captcha" />
        <img :src="captchaPath" @click="getCaptcha()" alt="" />
      </div>
      <div class="btn-box">
        <div>
          <button @click="dataFormSubmit()">登录</button>
          <button>注册</button>
        </div>
      </div>
    </form>
  </div>
</template>

<script>
import { getUUID } from "@/utils";
export default {
  data() {
    return {
      dataForm: {
        userName: "admin",
        password: "4869",
        uuid: "",
        captcha: ""
      },
      captchaPath: ""
    };
  },
  created() {
    this.getCaptcha();
  },
  methods: {
    // 提交表单
    dataFormSubmit() {
      this.$http({
        url: this.$http.adornUrl("/sys/login"),
        method: "post",
        data: this.$http.adornData({
          username: this.dataForm.userName,
          password: this.dataForm.password,
          uuid: this.dataForm.uuid,
          captcha: this.dataForm.captcha
        })
      }).then(({ data }) => {
        if (data && data.code === 0) {
          this.$cookie.set("token", data.token);
          this.$router.replace({ name: "home" });
        } else {
          this.getCaptcha();
          this.$message.error(data.msg);
        }
      });
    },
    // 获取验证码
    getCaptcha() {
      this.dataForm.uuid = getUUID();
      this.captchaPath = this.$http.adornUrl(
        `/captcha.jpg?uuid=${this.dataForm.uuid}`
      );
    }
  }
};
</script>

<style lang="css">
@charset "utf-8";

* {
  margin: 0;
  padding: 0;
}

body {
  height: 100vh;
  background: url(~@/assets/img/bg.jpg) no-repeat;
  background-size: cover;
  display: flex;
  justify-content: center;
  align-items: center;
}

.box {
  width: 350px;
  height: 350px;
  border-top: 1px solid rgba(255, 255, 255, 0.5);
  border-left: 1px solid rgba(255, 255, 255, 0.5);
  border-bottom: 1px solid rgba(255, 255, 255, 0.3);
  border-right: 1px solid rgba(255, 255, 255, 0.3);
  backdrop-filter: blur(10px);
  background: rgba(50, 50, 50, 0.2);
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  border-radius: 10px;
}

.box>h2 {
  color: rgba(255, 255, 255, 0.9);
  margin-bottom: 30px;
}

.box .input-box {
  display: flex;
  flex-direction: column;
  box-sizing: border-box;
  margin-bottom: 10px;
}

.box .input-box label {
  font-size: 13px;
  color: rgba(255, 255, 255, 0.9);
  margin-bottom: 5px;
}

.box .input-box input {
  letter-spacing: 1px;
  font-size: 14px;
  box-sizing: border-box;
  width: 250px;
  height: 35px;
  border-radius: 5px;
  border: 1px solid rgba(255, 255, 255, 0.5);
  background: rgba(255, 255, 255, 0.2);
  outline: none;
  padding: 0 12px;
  color: rgba(255, 255, 255, 0.9);
  transition: 0.2s;
}

.box .input-box input:focus {
  border: 1px solid rgba(255, 255, 255, 0.8);
}

.box .btn-box {
  width: 250px;
  display: flex;
  flex-direction: column;
  align-items: start;
}

.box .btn-box>a {
  outline: none;
  display: block;
  width: 250px;
  text-align: end;
  text-decoration: none;
  font-size: 13px;
  color: rgba(255, 255, 255, 0.9);
}

.box .btn-box>a:hover {
  color: rgba(255, 255, 255, 1);
}

.box .btn-box>div {
  margin-top: 10px;
  display: flex;
  justify-content: center;
  align-items: center;
}

.box .btn-box>div>button {
  outline: none;
  margin-top: 10px;
  display: block;
  font-size: 14px;
  border-radius: 5px;
  transition: 0.2s;
}

.box .btn-box>div>button:nth-of-type(1) {
  width: 120px;
  height: 35px;
  color: rgba(255, 255, 255, 0.9);
  border: 1px solid rgba(192, 119, 91, 0.7);
  background: rgba(192, 119, 91, 0.5);
}

.box .btn-box>div>button:nth-of-type(2) {
  width: 120px;
  height: 35px;
  margin-left: 10px;
  color: rgba(255, 255, 255, 0.9);
  border: 1px solid rgba(192, 119, 91, 0.7);
  background: rgba(192, 119, 91, 0.5);
}

.box .btn-box>div>button:hover {
  border: 1px solid rgba(251, 128, 71, 0.7);
  background: rgba(251, 128, 71, 0.5);
}
</style>
