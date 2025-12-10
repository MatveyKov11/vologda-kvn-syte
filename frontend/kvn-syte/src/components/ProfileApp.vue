<template>
    <div class="ui text container">
        <h2 class="ui header">
            <div class="content">
                Учётные записи
            </div>
        </h2>
    </div>
    <table class="ui table">
        <thead>
            <tr>
                <th>Логин</th>
                <th>Пароль</th>
                <th>Роль пользователя</th>
                <th></th>
            </tr>
        </thead>
        <tbody>
            <tr v-for="profile in profiles" :key="profile.id">
                <td>
                    <div class="ui fluid input">
                        <input type="text" name="login" v-model="profile.login">
                    </div>
                </td>
                <td>
                    <div class="ui fluid input">
                        <input type="text" name="password" v-model="profile.password">
                    </div>
                </td>
                <td>
                    <input class="ui input" type="radio" :name="'admin'+profile.id" v-model="profile.role" value="ADMIN">
                    <label :for="'team'+profile.id"> Организатор </label>
                    <input class="ui input" type="radio" :name="'team'+profile.id" v-model="profile.role" value="TEAM">
                    <label :for="'team'+profile.id"> Команда </label>
                </td>
                <td><i class="minus square icon" @click="deleteRow(profile.id)"></i></td>
            </tr>
        </tbody>
    </table>
    <button class="ui button" @click="addRow">
        <i class="plus icon"></i> Добавить учётную запись
    </button>
    <button class="ui button">
        <i class="check icon"></i> Сохранить изменения
    </button>
</template>

<script setup>
import { ref } from 'vue';

const profiles = ref([
    {
        id: 0,
        login: 'admin',
        password: '1234',
        role: 'ADMIN'
    },
     {
        id: 1,
        login: 'admin2',
        password: '1111',
        role: 'ADMIN'
    },
     {
        id: 2,
        login: 'comand35',
        password: '353535',
        role: 'TEAM'
    }
])

function deleteRow(id){
    profiles.value = profiles.value.filter(el => el.id != id)
    for(let i = 0; i < profiles.value.length; i++){
        profiles.value[i].id = i
    }
}

function addRow(){
    profiles.value.push({id: profiles.value.length})
}
</script>