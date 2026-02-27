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
                Страница редактора
            </div>
        </h2>
    </div>
    <div class="ui attached stackable menu">
        <div class="ui container">
            <a class="item"  @click="newPost">
                <span> Новый пост </span>
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

function newPost(){
    router.push({name: 'New Post'})
}

router.push({name: 'Editor Home'})
</script>