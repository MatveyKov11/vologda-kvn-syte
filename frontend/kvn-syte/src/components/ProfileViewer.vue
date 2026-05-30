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
            <th class="center aligned four wide">Логин</th>
            <th class="center aligned five wide">Пароль</th>
            <th class="center aligned four wide">Роль пользователя</th>
            <th class="center aligned two wide">Активирована</th>
            <th class="one wide"></th>
        </tr></thead>
        <tbody>
            <tr v-for="profile in profiles" :key="profile.id" @mouseover="profile.isVisible = true" @mouseleave="profile.isVisible = false">
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
                <td>
                    <form class="ui form">
                        <div class="field">
                            <select class="ui fluid dropdown" v-model="profile.isActive">
                                <option value="true"> Да </option>
                                <option value="false"> Нет </option>
                            </select>
                        </div>
                    </form>
                </td>
                <td><i class="minus square icon" @click="deleteRow(profile.id)" v-if="profile.isVisible"></i></td>
            </tr>
        </tbody>
    </table>
    <button class="ui button" @click="addRow">
        <i class="plus icon"></i> Добавить учётную запись
    </button>
    <button class="ui button" @click="saveChanges">
        <i class="check icon"></i> Сохранить изменения
    </button>
    <ChangePassWindow :profile="selectedProfile" v-if="isChanged" @quit="isChanged = false"/>
</template>

<script setup>
import router from '@/router';
import { ref } from 'vue';
import ChangePassWindow from './windows/ChangePassWindow.vue';

const profiles = ref([
    {
        id: 0,
        login: 'admin',
        password: '1234',
        role: 'ADMIN',
        isActive: true,
        isVisible: false // !!!
    },
     {
        id: 1,
        login: 'admin2',
        password: '1111',
        role: 'ADMIN',
        isActive: true,
        isVisible: false  // !!!
    },
     {
        id: 2,
        login: 'comand35',
        password: '353535',
        role: 'TEAM',
        isActive: false,
        isVisible: false  // !!!
    }
])

for(let i = 0; i < profiles.value.length; i++){
    profiles.value[i].isVisible = false
}

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

function saveChanges(){
    alert('Изменения сохранены!')
    router.push({name: 'Admin Home'})
}
</script>
