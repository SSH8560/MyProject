var username = document.querySelector('#username')
var usernameMsg = document.querySelector('#usernameMsg')
var password = document.querySelector('#password')
var passwordValidMsg = document.querySelector('#passwordValidMsg')
var passwordCheck = document.querySelector('#passwordCheck')
var passwordCheckMsg = document.querySelector('#passwordCheckMsg')

username.addEventListener('blur',(e)=>{
    if(username.value != ''){
        fetch('/member/duplicate', {
            method:'post',
            body:username.value
        }).then((response)=> response.json())
        .then((data)=>{
            if(data === true) {
                usernameMsg.innerText = '이미 사용중인 아이디입니다.'
                usernameMsg.style = 'color:red;'
            } else {
                usernameMsg.innerText = ''
                usernameMsg.style = 'display:none;'
            }
        })
    }
});


passwordCheck.addEventListener('blur',(e)=>{
    if (password.value != passwordCheck.value) {
        passwordCheckMsg.innerText = '비밀번호를 다시 한번 확인해주세요.'
        passwordCheckMsg.style = 'color:red;'
    } else {
        passwordCheckMsg.innerText = ''
        passwordCheckMsg.style = 'display:none;'
    }
})

password.addEventListener('blur', (e)=>{
    if(password.value != ''){
        const passwordRegexp = /^(?=.*[\w])(?=.*[!@#$%^&*])([\w!@#$%^&*]{8,16})$/
        if(passwordRegexp.test(password.value)){
            passwordValidMsg.innerText = ''
            passwordValidMsg.style = 'display:none;'
        } else {
            passwordValidMsg.innerText = '비밀번호 형식이 맞지 않습니다.'
            passwordValidMsg.style = 'color:red;'
        }
    }
})