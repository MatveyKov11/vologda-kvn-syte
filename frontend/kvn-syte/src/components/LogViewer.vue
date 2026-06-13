<template>
    <div class="ui container">
        <h2 class="ui header">
            <div class="content">
                Логи
            </div>
        </h2>
        <LogFilter @clear="clearFilter" @filter="(f) => applyFilter(JSON.parse(JSON.stringify(f)))"/>
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
            <tr v-for="(log, i) in filteredLogs" :key="i">
                <td>
                    <p @click="userId = log.userId" :class="log.userId == -1 ? 'not-interactive' : 'interactive'">#{{ log.user }}</p>
                </td>
                <td>
                    {{ log.action }}
                </td>
                <td>
                    <p @click="userId = log.objectId" :class="log.objectId == -1 ? 'not-interactive' : 'interactive'"
                        v-if="log.objectType == 'user'">#{{ log.object }}</p>
                    <p @click="tableId = log.objectId" :class="log.objectId == -1 ? 'not-interactive' : 'interactive'"
                        v-if="log.objectType == 'table'">#{{ log.object }}</p>
                    <p @click="postId = log.objectId" :class="log.objectId == -1 ? 'not-interactive' : 'interactive'"
                        v-if="log.objectType == 'post'">#{{ log.object }}</p>
                    <p @click="commentId = log.objectId" :class="log.objectId == -1 ? 'not-interactive' : 'interactive'"
                        v-if="log.objectType == 'comment'">#{{ log.object }}</p>
                    <p @click="styleId = log.objectId" :class="log.objectId == -1 ? 'not-interactive' : 'interactive'"
                        v-if="log.objectType == 'style'">#{{ log.object }}</p>
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
    <StyleWindow :styleId="styleId" v-if="styleId != -1" @quit="styleId = -1" @show="toStyleEditor"/>
</template>

<script setup>
import { ref } from 'vue';
import router from '@/router';
import UserWindow from './windows/UserWindow.vue';
import TableWindow from './windows/TableWindow.vue';
import PostWindow from './windows/PostWindow.vue';
import CommentWindow from './windows/CommentWindow.vue';
import LogFilter from './LogFilter.vue';
import StyleWindow from './windows/StyleWindow.vue';

const logs = ref([
    {
        user: 'admin2',
        userId: 2,
        userType: 'admin',
        action: 'Удалил стиль',
        object: 'style2',
        objectId: 2,
        objectType: 'style',
        time: '2026-02-20T19:03'
    },
    {
        user: 'admin2',
        userId: 2,
        userType: 'admin',
        action: 'Изменил стиль',
        object: 'style2',
        objectId: 2,
        objectType: 'style',
        time: '2026-02-20T19:02'
    },
    {
        user: 'admin1',
        userId: 1,
        userType: 'admin',
        action: 'Создал новый стиль',
        object: 'style2',
        objectId: 2,
        objectType: 'style',
        time: '2026-02-20T19:01'
    },
    {
        user: 'admin1',
        userId: 1,
        userType: 'admin',
        action: 'Создал новый стиль',
        object: 'style1',
        objectId: 1,
        objectType: 'style',
        time: '2026-02-20T19:01'
    },
    {
        user: 'admin2',
        userId: 2,
        action: 'Удалил комментарий',
        object: 'comment1',
        objectId: 1,
        objectType: 'comment',
        time: '2026-02-22T19:02'
    },
    {
        user: 'Аноним',
        userId: -1,
        userType: 'anon',
        action: 'Оставил комментарий',
        object: 'comment2',
        objectId: 2,
        objectType: 'comment',
        time: '2026-02-22T19:01'
    },
    {
        user: 'Аноним',
        userId: -1,
        userType: 'anon',
        action: 'Оставил комментарий',
        object: 'comment1',
        objectId: 1,
        objectType: 'comment',
        time: '2026-02-22T19:00'
    },
    {
        user: 'admin1',
        userId: 1,
        userType: 'admin',
        action: 'Опубликовал черновик поста',
        object: 'post2',
        objectId: 2,
        objectType: 'post',
        time: '2026-02-21T19:03'
    },
    {
        user: 'admin1',
        userId: 1,
        userType: 'admin',
        action: 'Изменил черновик поста',
        object: 'post2',
        objectId: 2,
        objectType: 'post',
        time: '2026-02-21T19:02'
    },
    {
        user: 'admin2',
        userId: 2,
        userType: 'admin',
        action: 'Создал черновик поста',
        object: 'post2',
        objectId: 2,
        objectType: 'post',
        time: '2026-02-21T19:01'
    },
    {
        user: 'admin1',
        userId: 1,
        userType: 'admin',
        action: 'Опубликовал новый пост',
        object: 'post1',
        objectId: 1,
        objectType: 'post',
        time: '2026-02-21T19:00'
    },
    {
        user: 'admin2',
        userId: 2,
        userType: 'admin',
        action: 'Удалил таблицу',
        object: 'table2',
        objectId: 2,
        objectType: 'table',
        time: '2026-02-20T19:03'
    },
    {
        user: 'admin2',
        userId: 2,
        userType: 'admin',
        action: 'Изменил таблицу',
        object: 'table2',
        objectId: 2,
        objectType: 'table',
        time: '2026-02-20T19:02'
    },
    {
        user: 'admin1',
        userId: 1,
        userType: 'admin',
        action: 'Создал новую таблицу',
        object: 'table2',
        objectId: 2,
        objectType: 'table',
        time: '2026-02-20T19:01'
    },
    {
        user: 'admin2',
        userId: 2,
        userType: 'admin',
        action: 'Создал новую таблицу',
        object: 'table1',
        objectId: 1,
        objectType: 'table',
        time: '2026-02-20T19:00'
    },
    {
        user: 'admin1',
        userId: 1,
        userType: 'admin',
        action: 'Добавил новую учётную запись',
        object: 'admin2',
        objectId: 2,
        objectType: 'user',
        time: '2026-02-19T19:03'
    },
    {
        user: 'admin1',
        userId: 1,
        userType: 'admin',
        action: 'Удалил учётную запись',
        object: 'admin4',
        objectId: 4,
        objectType: 'user',
        time: '2026-02-19T19:02'
    },
    {
        user: 'admin1',
        userId: 1,
        userType: 'admin',
        action: 'Заблокировал учётную запись',
        object: 'admin4',
        objectId: 4,
        objectType: 'user',
        time: '2026-02-19T19:01'
    },
    {
        user: 'admin1',
        userId: 1,
        userType: 'admin',
        action: 'Добавил новую учётную запись',
        object: 'admin4',
        objectId: 4,
        objectType: 'user',
        time: '2026-02-19T19:00'
    }
])

const filteredLogs = ref([])
logs.value.forEach((log) => {
    filteredLogs.value.push(log)
})

function clearFilter(){
    let filteredLogsCopy = []
    logs.value.forEach((log) => {
        filteredLogsCopy.push(log)
    })
    filteredLogs.value = filteredLogsCopy
}

function applyFilter(f){
    let filteredLogsCopy = []
    logs.value.forEach((log) => {
        if(f.subject.length == 0 || f.subject.includes(log.userType)){
            filteredLogsCopy.push(log)
        }
    })
    let filteredLogsCopy2 = []
    if (f.action.includes("Созд")){
        f.action.push("Добав")
        f.action.push("Остав")
        f.action.push("Опублик")
    }
    if (f.action.includes("Измен")){
        f.action.push("Заблок")
        f.action.push("Разблок")
    }
    filteredLogsCopy.forEach((log) => {
        if(f.action.length == 0){
            filteredLogsCopy2.push(log)
        }else{
            f.action.forEach((act) => {
                if(log.action.startsWith(act)){
                    filteredLogsCopy2.push(log)
                }
            })
            
        }
    })
    filteredLogsCopy = []
    filteredLogsCopy2.forEach((log) => {
        if(f.object.length == 0 || f.object.includes(log.type)){
            filteredLogsCopy.push(log)
        }
    })
    filteredLogsCopy2 = []
    filteredLogsCopy.forEach((log) => {
        if(f.before == 0 || f.before >= log.time){
            filteredLogsCopy2.push(log)
        }
    })
    filteredLogsCopy = []
    filteredLogsCopy2.forEach((log) => {
        if(f.after == 0 || f.after <= log.time){
            filteredLogsCopy.push(log)
        }
    })
    filteredLogs.value = filteredLogsCopy
}

const userId = ref(-1)
const tableId = ref(-1)
const postId = ref(-1)
const commentId = ref(-1)
const styleId = ref(-1)

function toProfiles(){
    router.push({name: 'Profiles'})
}

function toTables(){
    router.push({name: 'Tables'})
}

function toPostEditor(){
    router.push({name: 'New Post'})
}

function toStyleEditor(){
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