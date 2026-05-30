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
                    <p @click="userId = 1" class="interactive">asd</p>
                </td>
                <td>
                    asd
                </td>
                <td>
                    <p @click="tableId = 1" class="interactive">asd</p>
                </td>
                <td>
                    <p @click="postId = 1" class="interactive">asd</p>
                </td>
            </tr>
        </tbody>
        </table>
    </div>
    <UserWindow :userId="userId" v-if="userId != -1" @quit="userId = -1" @edit="toProfiles" @delete="deleteUser" @block="blockUser"/>
    <TableWindow :tableId="tableId" v-if="tableId != -1" @quit="tableId = -1" @edit="toTables"/>
    <PostWindow :postId="postId" v-if="postId != -1" @quit="postId = -1" @edit="toPosts"/>
</template>

<script setup>
import { ref } from 'vue';
import router from '@/router';
import UserWindow from './windows/UserWindow.vue';
import TableWindow from './windows/TableWindow.vue';
import PostWindow from './windows/PostWindow.vue';

const logs = ref([
    {
        pos: 0
    },
    {
        pos: 1
    }
])

const userId = ref(-1)
const tableId = ref(-1)
const postId = ref(-1)

function toProfiles(){
    router.push({name: 'Profiles'})
}

function toTables(){
    router.push({name: 'Tables'})
}

function toPosts(){
    router.push({name: 'New Post'})
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

<style scoped>
.interactive{
    cursor: pointer;
    color: rgb(0, 180, 180);
    text-decoration: underline;
}
</style>