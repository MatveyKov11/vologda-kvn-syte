<template>
    <div class="ui container">
        <h2 class="ui header">
            <div class="content">
                Логи
            </div>
        </h2>
        <table class="ui table">
        <thead>
            <tr>
                <th class="center aligned">Субъект</th>
                <th class="center aligned">Действие</th>
                <th class="center aligned">Объект</th>
                <th class="center aligned">Время</th>
            </tr>
        </thead>
        <tbody>
            <tr v-for="log in logs" :key="log.pos">
                <td>
                    <p @click="userId = 1">asd</p>
                </td>
                <td>
                    asd
                </td>
                <td>
                    asd
                </td>
                <td>
                    asd
                </td>
            </tr>
        </tbody>
        </table>
    </div>
    <UserWind :userId="userId" v-if="userId != -1" @quit="userId = -1" @edit="toProfiles" @delete="deleteUser" @block="blockUser"/>
</template>

<script setup>
import { ref } from 'vue';
import router from '@/router';
import UserWind from './windows/UserWind.vue';

const logs = ref([
    {
        pos: 0
    },
    {
        pos: 1
    }
])

const userId = ref(-1)

function toProfiles(){
    router.push({name: 'Profiles'})
}

function deleteUser(){
    alert("Заглушка!!! Пользователь удалён")
    userId.value = -1
}

function blockUser(){
    alert("Заглушка!!! Пользователь заблокирован")
    userId.value = -1
}
</script>