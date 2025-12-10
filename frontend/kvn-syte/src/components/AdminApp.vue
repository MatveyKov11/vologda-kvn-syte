<template>
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
            <a class="item"  @click="profiles">
                <span> Учётные записи </span>
            </a>
            <a class="item"  @click="contests">
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

function logs() {
    router.push({name: 'Logs'})
}

function results() {
    router.push({name: 'Results'})
}

function teams() {
    router.push({name: 'Teams'})
}

function schedule() {
    router.push({name: 'Schedule'})
}

function profiles() {
    router.push({name: 'Profiles'})
}

function contests() {
    router.push({name: 'Contests'})
}

router.push({name: 'Logs'})
</script>