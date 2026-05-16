<template>
    <div class="ui left floated icon buttons">
        <div class="ui icon button" @click="home">
            <i class="home icon"></i>
        </div>
        <div class="ui icon button" @click="edit">
            <i class="edit icon"></i>
        </div>
        <div class="ui icon button" @click="admin">
            <i class="table icon"></i>
        </div>
    </div>
    <div class="ui text container">
        <h2 class="ui header">
            <div class="content">
                Страница админа
            </div>
        </h2>
    </div>
    <div class="ui attached stackable menu">
        <div class="ui container">
            <a class="item"  @click="logs">
                <span> Логи </span>
            </a>
            <a class="item"  @click="results">
                <span> Результаты игры </span>
            </a>
            <a class="item"  @click="teams">
                <span> Команды </span>
            </a>
            <a class="item"  @click="schedule">
                <span> Расписание игр на сезон </span>
            </a>
            <a class="item"  @click="tables">
                <span> Таблицы </span>
            </a>
            <a class="item"  @click="profiles">
                <span> Учётные записи </span>
            </a>
            <a class="item"  @click="contests_table">
                <span> Список конкурсов </span>
            </a>
        </div>
    </div>
    <div class="ui clearing divider"></div>
    <div class="ui text container">
        <router-view></router-view>
    </div>
</template>

<script setup>
import router from '@/router';

function home() {
    router.push({name: 'Home'})
}

function edit() {
    router.push({name: 'Editor Home'})
}

function admin() {
    router.push({name: 'Admin Home'})
}

function logs() {
    router.push({name: 'Logs'})
}

function profiles() {
    router.push({name: 'Profiles'})
}

function tables() {
    router.push({name: 'Tables'})
}

router.push({name: 'Logs'})
</script>