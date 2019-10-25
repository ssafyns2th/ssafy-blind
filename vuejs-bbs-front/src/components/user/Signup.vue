<template>
  <div class="container">
    <div class="row">
      <h1>회원 가입</h1>
    </div>
    <div class="row">
      <div class="row">
        <div class="input-field col s12">
          <input
            id="username"
            v-model="user.username"
            type="text"
            class="validate"
            placeholder="사용자 아이디"
          />
        </div>
      </div>
      <div class="row">
        <div class="input-field col s12">
          <input
            id="password"
            v-model="user.password"
            type="password"
            class="validate"
            placeholder="비밀번호"
          />
        </div>
      </div>
      <div class="row">
        <div class="input-field col s12">
          <input
            id="passwordre"
            v-model="user.confirmpassword"
            type="password"
            class="validate"
            placeholder="비밀번호 확인"
          />
        </div>
      </div>
      <div class="row">
        <div class="input-field col s12">해시 코드 : {{hashCode}}</div>
      </div>
      <a class="btn waves-effect waves-light" @click="isExist">
        페이지 확인
        <i class="material-icons right">send</i>
      </a>

      <a class="btn waves-effect waves-light" @click="signup">
        회원가입
        <i class="material-icons right">send</i>
      </a>
    </div>
  </div>
</template>

<script>
import axios from "../../libs/axios.custom";
import notification from "../../libs/notification";

export default {
  data: () => ({
    user: {
      username: "",
      password: "",
      confirmpassword: ""
    },
    hashCode: 0
  }),

  created() {
    this.createHash();
  },

  methods: {
    async signup() {
      try {
        const res = await axios.post("/api/v1/user/signup", this.user);
        notification.success(res, "가입성공", () => {
          this.$router.push("/");
        });
      } catch (err) {
        err.response.data.errors.forEach(error => {
          this.$notify({
            group: "noti",
            type: "error",
            duration: 6000,
            text: error.defaultMessage
          });
        });
      }
    },
    async isExist() {
      var temp = this.user.username;
      var flag = false;
      var xhr = new XMLHttpRequest();
      var paramVal = this.hashCode;
      console.log("hashCode = " + paramVal);
      var target = "https://lab.ssafy.com/api/v4/projects/";
      xhr.open("GET", target + "?search=" + paramVal);
      xhr.send();

      xhr.onreadystatechange = function() {
        if (xhr.readyState === XMLHttpRequest.DONE) {
          if (xhr.status == 200) {
            let loadedJSON = JSON.parse(xhr.responseText);

            for (var i = 0; i < Object.keys(loadedJSON).length; i++) {
              var info = loadedJSON[i].http_url_to_repo
                .substr(22, loadedJSON[i].http_url_to_repo.length)
                .split("/");

              console.log("찾아 온 값 = " + info[0] + "  입력 된 값 = " + temp);
              if (info[0] == temp) {
                console.log("flag true");
                flag = true;
              }
            }
            if (flag) {
              alert("매칭성공");
            }
          } else {
            alert("fail to load");
          }
        }
      };

      // var obj = JSON.parse(
      //   "https://lab.ssafy.com/api/v4/projects/?search=210105626"
      // );
      // console.log(obj.id);
    },
    createHash() {
      var i, chr;

      var currentDateWithFormat = new Date()
        .toJSON()
        .replace(/-/g, "")
        .replace(/:/g, "");
      console.log(currentDateWithFormat);

      for (i = 0; i < currentDateWithFormat.length; i++) {
        chr = currentDateWithFormat.charCodeAt(i);
        this.hashCode = (this.hashCode << 5) - this.hashCode + chr;
        this.hashCode = this.hashCode & this.hashCode;
      }
      if (this.hashCode < 0) {
        this.hashCode *= -1;
      }
      console.log(this.hashCode);
    },
    hex2a(hex) {
      var str = "";
      for (var i = 0; i < hex.length; i += 2) {
        var v = parseInt(hex.substr(i, 2), 16);
        if (v) str += String.fromCharCode(v);
      }
      return str;
    }
  }
};
</script>
