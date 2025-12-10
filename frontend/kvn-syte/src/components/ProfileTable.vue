<template>
    <div class="ui text container">
        <h2 class="ui header">
            <div class="content">
                Учётные записи
            </div>
        </h2>
    </div>
    <table class="ui table">
        <thead><tr>
            <th class="five wide">Логин</th>
            <th class="five wide">Пароль</th>
            <th class="five wide">Роль пользователя</th>
            <th class="one wide"></th>
        </tr></thead>
        <tbody>
            <tr v-for="profile in profiles" :key="profile.id">
                <td>
                    <div class="ui fluid input">
                        <input type="text" name="login" v-model="profile.login">
                    </div>
                </td>
                <td>
                    <button class="ui button" @click="openChangePass(profile.id)">
                        Поменять пароль
                    </button>
                </td>
                <td>
                    <form class="ui form">
                        <div class="field">
                            <select class="ui fluid dropdown" v-model="profile.role">
                                <option value="ADMIN"> Организатор </option>
                                <option value="TEAM"> Команда </option>
                            </select>
                        </div>
                    </form>
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
    <ChangePassWind :profile="selectedProfile" v-if="isChanged" @quit="isChanged = false"/>
</template>

<script setup>
import { ref } from 'vue';
import ChangePassWind from './ChangePassWind.vue';

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

const selectedProfile = ref({})
let isChanged = ref(false)

function openChangePass(id){
    isChanged.value = true
    selectedProfile.value = profiles.value[id]
}
</script>