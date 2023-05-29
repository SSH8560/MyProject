var selectCharacter = document.querySelector("#selectCharacter")
var selectStance = document.querySelector("#selectStance")
var character

selectCharacter.addEventListener('change',()=>{
    fetch('/ge/api/character',
        {
            method:'post',
            body:selectCharacter.value
        }).then((response)=> response.json())
        .then((data)=>{
            character = data
            selectStance.innerHTML = ''
            character.stance.forEach(element => {
                temp = document.createElement('option')
                temp.innerHTML = element
                selectStance.append(temp)
            })
        })
})