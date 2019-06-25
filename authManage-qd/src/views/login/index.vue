<template>
  <div class="login">
    <el-form
      ref="loginForm"
      :model="loginForm"
      :rules="loginRules"
      label-position="left"
      label-width="0px"
      class="login-form"
    >
      <h3 class="title">后台管理系统</h3>
      <el-form-item prop="username">
        <el-input v-model="loginForm.username" type="text" auto-complete="off" placeholder="账号">
          <svg-icon
            slot="prefix"
            icon-class="user"
            class="el-input__icon"
            style="height: 39px;width: 13px;margin-left: 2px;"
          />
        </el-input>
      </el-form-item>
      <el-form-item prop="password">
        <el-input v-model="loginForm.password" type="password" auto-complete="off" placeholder="密码">
          <svg-icon
            slot="prefix"
            icon-class="password"
            class="el-input__icon"
            style="height: 39px;width: 13px;margin-left: 2px;"
          />
        </el-input>
      </el-form-item>
      <el-checkbox v-model="loginForm.rememberMe" class="login-rememberMe">记住密码</el-checkbox>

      <el-form-item style="width: 100%">
        <el-button size="medium" style="width: 100%" type="primary" @click.native.prevent="handleLogin">
          <span v-if="!loading">登陆</span>
          <span v-else>登陆中...</span>
        </el-button>

      </el-form-item>
      <p class="login-tip">系统默认用户名：admin，密码：123456</p>
    </el-form>
  </div>
</template>
<script>
import Config from '@/config'
import Cookies from 'js-cookie'
export default {
  data() {
    return {
      loginForm: {
        username: 'admin',
        password: 'admin',
        rememberMe: false
      },
      loginRules: {
        username: [{ required: true, trigger: 'blur', message: '用户名不能为空' }],
        password: [{ required: true, trigger: 'blur', message: '密码不能为空' }]
      },
      loading: false
    }
  },
  methods: {
    handleLogin() {
      this.$refs.loginForm.validate(valid => {
        const user = this.loginForm
        if (valid) {
          this.loading = true
          if (user.rememberMe) {
            Cookies.set('username', user.username, { expires: Config.passCookieExpires })
            Cookies.set('password', user.password, { expires: Config.passCookieExpires })
            Cookies.set('rememberMe', user.rememberMe, { expires: Config.passCookieExpires })
          } else {
            Cookies.remove('username')
            Cookies.remove('password')
            Cookies.remove('rememberMe')
          }
        }
      })
    }
  }
}
</script>
<style lang="scss" scoped="">
  .login {
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100%;
    background-image: url(https://aurora-1255840532.cos.ap-chengdu.myqcloud.com/1547428971990.jpg);
    background-size: cover;
    .login-form {
      border-radius: 6px;
      background: #ffffff;
      width: 365px;
      padding: 25px 25px 5px 25px;
      .el-input {
        height: 38px;
        input {
          height: 38px;
        }
      }
      .login-rememberMe {
        margin: 0px 0px 25px 0px;
      }
      .title {
        margin: 0px auto 30px auto;
        text-align: center;
        color: #707070;
      }
      .login-tip {
        font-size: 13px;
        text-align: center;
        color: #bfbfbf;
      }
    }

  }
</style>
