<template>
    <div class="ui container">
        <h2 class="ui header">
            <div class="content">
                Логи
            </div>
        </h2>
        <table class="ui celled table">
        <thead>
            <tr>
                <th class="center aligned">Субъект</th>
                <th class="center aligned">Действие</th>
                <th class="center aligned">Объект</th>
                <th class="center aligned">Время</th>
            </tr>
        </thead>
        <tbody>
            <tr v-for="(log, i) in logs" :key="i">
                <td>
                    <p @click="userId = 1" :class="log.userId == -1 ? 'not-interactive' : 'interactive'">#{{ log.user }}</p>
                </td>
                <td>
                    {{ log.action }}
                </td>
                <td>
                    <p @click="userId = log.objectId" :class="log.objectId == -1 ? 'not-interactive' : 'interactive'"
                        v-if="log.type == 'user'">#{{ log.object }}</p>
                    <p @click="tableId = log.objectId" :class="log.objectId == -1 ? 'not-interactive' : 'interactive'"
                        v-if="log.type == 'table'">#{{ log.object }}</p>
                    <p @click="postId = log.objectId" :class="log.objectId == -1 ? 'not-interactive' : 'interactive'"
                        v-if="log.type == 'post'">#{{ log.object }}</p>
                    <p @click="commentId = log.objectId" :class="log.objectId == -1 ? 'not-interactive' : 'interactive'"
                        v-if="log.type == 'comment'">#{{ log.object }}</p>
                </td>
                <td>
                    {{ log.time }}
                </td>
            </tr>
        </tbody>
        </table>
    </div>
    <UserWindow :userId="userId" v-if="userId != -1" @quit="userId = -1" @edit="toProfiles" @delete="deleteUser" @block="blockUser"/>
    <TableWindow :tableId="tableId" v-if="tableId != -1" @quit="tableId = -1" @edit="toTables"/>
    <PostWindow :postId="postId" v-if="postId != -1" @quit="postId = -1" @edit="toPostEditor"/>
    <CommentWindow :commentId="commentId" v-if="commentId != -1" @quit="commentId = -1" @show="toPost" @delete="deleteComment"/>
</template>

<script setup>
import { ref } from 'vue';
import router from '@/router';
import UserWindow from './windows/UserWindow.vue';
import TableWindow from './windows/TableWindow.vue';
import PostWindow from './windows/PostWindow.vue';
import CommentWindow from './windows/CommentWindow.vue';

const logs = ref([
    {
        user: 'admin2',
        userId: 2,
        action: 'Удалил комментарий',
        object: 'comment1',
        objectId: 1,
        type: 'comment',
        time: '22.02.26 19:02:00'
    },
    {
        user: 'Аноним',
        userId: -1,
        action: 'Оставил комментарий',
        object: 'comment2',
        objectId: 2,
        type: 'comment',
        time: '22.02.26 19:01:00'
    },
    {
        user: 'Аноним',
        userId: -1,
        action: 'Оставил комментарий',
        object: 'comment1',
        objectId: 1,
        type: 'comment',
        time: '22.02.26 19:00:00'
    },
    {
        user: 'admin1',
        userId: 1,
        action: 'Опубликовал черновик поста',
        object: 'post2',
        objectId: 2,
        type: 'post',
        time: '21.02.26 19:03:00'
    },
    {
        user: 'admin1',
        userId: 1,
        action: 'Изменил черновик поста',
        object: 'post2',
        objectId: 2,
        type: 'post',
        time: '21.02.26 19:02:00'
    },
    {
        user: 'admin2',
        userId: 2,
        action: 'Создал черновик поста',
        object: 'post2',
        objectId: 2,
        type: 'post',
        time: '21.02.26 19:01:00'
    },
    {
        user: 'admin1',
        userId: 1,
        action: 'Опубликовал новый пост',
        object: 'post1',
        objectId: 1,
        type: 'post',
        time: '21.02.26 19:00:00'
    },
    {
        user: 'admin2',
        userId: 2,
        action: 'Удалил таблицу',
        object: 'table2',
        objectId: 2,
        type: 'table',
        time: '20.02.26 19:03:00'
    },
    {
        user: 'admin2',
        userId: 2,
        action: 'Изменил таблицу',
        object: 'table2',
        objectId: 2,
        type: 'table',
        time: '20.02.26 19:02:00'
    },
    {
        user: 'admin1',
        userId: 1,
        action: 'Создал новую таблицу',
        object: 'table2',
        objectId: 2,
        type: 'table',
        time: '20.02.26 19:01:00'
    },
    {
        user: 'admin2',
        userId: 2,
        action: 'Создал новую таблицу',
        object: 'table1',
        objectId: 1,
        type: 'table',
        time: '20.02.26 19:00:00'
    },
    {
        user: 'admin1',
        userId: 1,
        action: 'Добавил новую учётную запись',
        object: 'admin2',
        objectId: 2,
        type: 'user',
        time: '19.02.26 19:03:00'
    },
    {
        user: 'admin1',
        userId: 1,
        action: 'Удалил учётную запись',
        object: 'admin4',
        objectId: 4,
        type: 'user',
        time: '19.02.26 19:02:00'
    },
    {
        user: 'admin1',
        userId: 1,
        action: 'Заблокировал учётную запись',
        object: 'admin4',
        objectId: 4,
        type: 'user',
        time: '19.02.26 19:01:00'
    },
    {
        user: 'admin1',
        userId: 1,
        action: 'Добавил новую учётную запись',
        object: 'admin4',
        objectId: 4,
        type: 'user',
        time: '19.02.26 19:00:00'
    }
])

const userId = ref(-1)
const tableId = ref(-1)
const postId = ref(-1)
const commentId = ref(-1)

function toProfiles(){
    router.push({name: 'Profiles'})
}

function toTables(){
    router.push({name: 'Tables'})
}

function toPostEditor(){
    router.push({name: 'New Post'})
}

function toPost(){
    router.push({name: 'Home'})
}

function deleteUser(){
    alert("Заглушка!!! Пользователь удалён")
    userId.value = -1
}

function deleteComment(){
    alert("Заглушка!!! Комментарий удалён")
    commentId.value = -1
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